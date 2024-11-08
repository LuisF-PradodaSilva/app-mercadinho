package com.mercadinho.services;

import com.mercadinho.domains.dtos.ProdutoDTO;
import com.mercadinho.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
    }
}
