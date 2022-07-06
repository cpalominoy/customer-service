package com.pandero.customerservice.core.service.impl;

import com.pandero.customerservice.core.service.CustomerService;
import com.pandero.customerservice.persistence.repository.CustomerRepository;
import com.pandero.customerservice.shared.CustomerDto;
import com.pandero.customerservice.shared.mapper.CustomerDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * La clase CustomerServiceImpl provee la implementación para la definición del contrato
 * CustomerService.
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerDtoMapper customerDtoMapper;
  /**
   * Retorna el cliente para el correo electrónico dado o nulo si no se puede encontrar un usuario.
   *
   * @param email Correo Electrónico asociado al cliente que se desea buscar.
   * @return un cliente para el correo electrónico dado o nulo si no se puede encontrar un usuario.
   * @throws NullPointerException en caso de que la entidad Customer sea {@literal null}
   */
  @Override
  public CustomerDto findByEmail(String email) {

    CustomerDto customerDto =
        customerRepository
            .findByEmail(email)
            .map(customerDtoMapper::toCustomerDto)
            .orElseThrow(() -> new RuntimeException("Not found Customer"));

    return customerDto;
  }
}
