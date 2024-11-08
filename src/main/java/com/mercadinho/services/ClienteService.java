package com.mercadinho.services;

import com.mercadinho.domains.dtos.ClienteDTO;
import com.mercadinho.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
    }
}
