package com.pandero.customerservice.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

  @Schema(
      title = "Nombre",
      example = "Ronaldhino",
      description = "Nombre del cliente",
      required = true)
  private String firstName;

  @Schema(
      title = "Apellido",
      example = "Gaucho",
      description = "Apellido del cliente",
      required = true)
  private String lastName;

  @Schema(
      title = "Correo Electrónico",
      example = "ronaldhino@gmail.com",
      description = "Correo Electrónico del cliente",
      required = true)
  private String email;

  @Schema(
      title = "Documento Nacional de Identidad",
      example = "4561237",
      description = "Documento de identidad del cliente",
      required = true)
  private String dni;
}
