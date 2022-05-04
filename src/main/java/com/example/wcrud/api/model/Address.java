package com.example.wcrud.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stName;

    private String number;

    private String complement;

    private String cep;

    private LocalDate createdAt;

    private String weather;

    @ManyToOne
    private Customer customer;

}
