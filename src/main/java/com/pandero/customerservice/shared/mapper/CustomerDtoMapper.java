package com.pandero.customerservice.shared.mapper;

import com.pandero.customerservice.persistence.domain.Customer;
import com.pandero.customerservice.shared.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/** La clase CustomerDtoMapper describe las conversiones admitidas entre la entidad Customer */
@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {

  CustomerDtoMapper INSTANCE = Mappers.getMapper(CustomerDtoMapper.class);

  /**
   * Convierte la entidad Customer a un objeto CustomerDto.
   *
   * @param customer entidad customer(cliente).
   * @return objeto CustomerDto.
   */
  @Mapping(target = "firstName", source = "firstName")
  CustomerDto toCustomerDto(Customer customer);
}
