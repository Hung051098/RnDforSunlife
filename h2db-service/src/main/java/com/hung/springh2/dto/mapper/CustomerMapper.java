package com.hung.springh2.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.hung.springh2.dto.response.CustomerDTO;
import com.hung.springh2.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );
	CustomerDTO mapperCustomer(Customer cutomer);
}
