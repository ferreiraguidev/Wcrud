package com.example.wcrud.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViaCep {

    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
    private String logradouro;

}
