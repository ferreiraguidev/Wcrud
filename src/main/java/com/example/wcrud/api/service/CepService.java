package com.example.wcrud.api.service;

import com.example.wcrud.api.model.ViaCep;
import com.example.wcrud.api.repository.ViaCepClient;
import org.springframework.stereotype.Service;


@Service
public class CepService {

//     private final not working either *
    private final ViaCepClient viaCepClient;

    public CepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public ViaCep getCep(String cep){
        return viaCepClient.buscaPorEndereco(cep);

    }
}
