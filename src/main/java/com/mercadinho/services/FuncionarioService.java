package com.mercadinho.services;

import com.mercadinho.domains.dtos.FuncionarioDTO;
import com.mercadinho.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepository.findAll().stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
    }
}
