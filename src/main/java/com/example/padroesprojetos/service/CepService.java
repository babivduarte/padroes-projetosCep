package com.example.padroesprojetos.service;

import com.example.padroesprojetos.model.Endereco;
public interface CepService {
    Endereco buscaEndereco(String cep);
}
