package com.example.wcrud.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViaCEPResponseDTO {

    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
    private String logradouro;
}
