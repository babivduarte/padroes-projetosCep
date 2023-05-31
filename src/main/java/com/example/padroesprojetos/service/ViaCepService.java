package com.example.padroesprojetos.service;

import com.example.padroesprojetos.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
//@Service
public class ViaCepService implements CepService {
    public static final String BASE_URL = "http://viacep.com.br";
    public static final String ENDPOINT = "/ws/%s/json/";
    private final WebClient client;

    public ViaCepService(){
        client = WebClient.builder().baseUrl(BASE_URL).build();
    }

    @Override
    public Endereco buscaEndereco(String cep) {
        return client.get().uri(ENDPOINT.formatted(cep))
                .retrieve()
                .bodyToMono(Endereco.class)
                .block();
    }
}
