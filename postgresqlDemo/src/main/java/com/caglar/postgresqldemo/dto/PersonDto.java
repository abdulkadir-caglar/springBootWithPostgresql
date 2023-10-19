package com.caglar.postgresqldemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<String> addresses;
}
