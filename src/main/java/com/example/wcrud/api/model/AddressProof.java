package com.example.wcrud.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AddressProof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    private String createdAt;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
