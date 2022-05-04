package com.example.wcrud.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerRequestDTO {

    private String name;
    private String cpf;
    private String email;
    private LocalDate createdAt;

}
