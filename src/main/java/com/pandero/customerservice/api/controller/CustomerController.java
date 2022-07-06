package com.pandero.customerservice.api.controller;

import com.pandero.customerservice.core.service.CustomerService;
import com.pandero.customerservice.shared.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "Controlador para servicio del cliente")
public class CustomerController {

  private final CustomerService customerService;

  @Operation(
      summary = "Búsqueda del cliente por email.",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(schema = @Schema(implementation = CustomerDto.class)))
      })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public CustomerDto getCustomerByEmail(
      @Parameter(description = "Campo Email", example = "ronaldhino@gmail.com", required = true)
          @RequestParam(name = "email")
          String email) {
    String email2 = email;
    return customerService.findByEmail(email);
  }
}
