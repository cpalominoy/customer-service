package com.pandero.customerservice.core.service;

import com.pandero.customerservice.shared.CustomerDto;

/** Contrato para las operaciones de servicio del cliente */
public interface CustomerService {

  /**
   * Retorna el cliente para el correo electrónico dado o nulo si no se puede encontrar un usuario.
   *
   * @param email Correo Electrónico asociado al cliente que se desea buscar.
   * @return un cliente para el correo electrónico dado o nulo si no se puede encontrar un usuario.
   * @throws NullPointerException en caso de que la entidad Customer sea {@literal null}
   */
  CustomerDto findByEmail(String email);
}
