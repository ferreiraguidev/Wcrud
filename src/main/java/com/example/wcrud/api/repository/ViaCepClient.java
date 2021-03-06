package com.example.wcrud.api.repository;


import com.example.wcrud.api.dtos.ViaCEPResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    ViaCEPResponseDTO buscaPorEndereco(@PathVariable("cep") String cep);
}
