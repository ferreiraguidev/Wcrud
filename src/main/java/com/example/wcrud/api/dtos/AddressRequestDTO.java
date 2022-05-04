package com.example.wcrud.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AddressRequestDTO {

    private Long id;

    private String stName;
    private String number;
    private String complement;
    private String cep;
    private LocalDate createdAt;
    private String weather;

    private Long customerId;

}
