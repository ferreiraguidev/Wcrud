package com.example.wcrud.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private String cep;

    private String logradouro;

    private LocalDate createdAt;

    private String weather;

    @NotNull
    @ManyToOne
    private Customer customer;

}
