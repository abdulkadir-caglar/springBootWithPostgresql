package com.caglar.postgresqldemo.service;

import com.caglar.postgresqldemo.dto.PersonDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    PersonDto create(PersonDto personDto);

    void delete (Long id);

    List<PersonDto> findAll();

    PersonDto findAll(Pageable pageable);

}
