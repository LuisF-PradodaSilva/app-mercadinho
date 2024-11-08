package com.mercadinho.services;

import com.mercadinho.domains.Cliente;
import com.mercadinho.domains.dtos.ClienteDTO;
import com.mercadinho.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElse(null);
    }

    public Cliente findByCpf(String cpf) {
        Optional<Cliente> obj = clienteRepository.findByCpf(cpf);
        return obj.orElse(null);
    }
}
