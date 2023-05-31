package com.example.padroesprojetos.service;

import com.example.padroesprojetos.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PostmonCepService implements CepService {
    public static final String BASE_URL = "https://api.postmon.com.br";
    public static final String ENDPOINT = "/v1/cep/%s";
    private final WebClient client;

    public PostmonCepService(){
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
