package com.gilberto.apirestproject.mapper;

import com.gilberto.apirestproject.dto.request.PersonDTO;
import com.gilberto.apirestproject.entity.Person;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO PersonDTO);

    PersonDTO toDTO(Person person);
}