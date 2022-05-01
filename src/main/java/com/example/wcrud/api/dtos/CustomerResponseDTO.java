package com.example.wcrud.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CustomerResponseDTO {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate createdAt;
}
