package com.hung.springh2.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hung.springh2.dto.response.CustomerDetailDTO;
import com.hung.springh2.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerDetailMapper {

	CustomerDetailDTO mapperCustomer(Customer cutomer);
}
