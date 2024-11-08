package com.mercadinho.services;

import com.mercadinho.domains.dtos.FuncionarioDTO;
import com.mercadinho.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepository.findAll().stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
    }
}
