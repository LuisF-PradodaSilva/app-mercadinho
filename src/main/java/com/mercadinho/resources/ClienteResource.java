package com.mercadinho.resources;

import com.mercadinho.domains.dtos.ClienteDTO;
import com.mercadinho.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.ok().body(clienteService.findAll());
    }
}