package com.mercadinho.resources;

import com.mercadinho.domains.dtos.FuncionarioDTO;
import com.mercadinho.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }
}