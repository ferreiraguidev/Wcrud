package com.example.wcrud.api.service;

import com.example.wcrud.api.model.ViaCep;
import com.example.wcrud.api.repository.ViaCepClient;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CepService {

    private final ViaCepClient viaCepClient;

    public CepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public ViaCep getCep(String cep){
        return viaCepClient.buscaPorEndereco(cep);

    }
}
