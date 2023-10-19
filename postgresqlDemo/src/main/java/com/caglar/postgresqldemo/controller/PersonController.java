package com.caglar.postgresqldemo.controller;

import com.caglar.postgresqldemo.dto.PersonDto;
import com.caglar.postgresqldemo.service.PersonService;
import com.caglar.postgresqldemo.service.impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.create(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }
}
