package com.example.wcrud.api.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class AddressRequestDTO {

    private Long id;

    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
    private String logradouro;
    private String weather;
    private LocalDate createdAt;

    @NotNull
    private Long customerId;

}
