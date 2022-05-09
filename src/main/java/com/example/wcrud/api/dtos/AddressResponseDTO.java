package com.example.wcrud.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AddressResponseDTO {

    private Long id;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
    private String logradouro;
    private LocalDate createdAt;
    private String weather;

    private AddressProofResponseDTO addressProof;

}
