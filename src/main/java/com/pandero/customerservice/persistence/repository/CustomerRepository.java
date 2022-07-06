package com.pandero.customerservice.persistence.repository;

import com.pandero.customerservice.persistence.domain.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repositorio de la entidad Cliente. */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  /**
   * Búsqueda del usuario por el campo email.
   *
   * @param email correo electrónico del cliente.
   * @return Datos del cliente.
   */
  Optional<Customer> findByEmail(String email);
}
