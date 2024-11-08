package com.mercadinho.services;

import com.mercadinho.domains.dtos.VendaDTO;
import com.mercadinho.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<VendaDTO> findAll() {
        return vendaRepository.findAll().stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
    }
}
