package com.mercadinho.resources;

import com.mercadinho.domains.dtos.VendaDTO;
import com.mercadinho.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/venda")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> findAll() {
        return ResponseEntity.ok().body(vendaService.findAll());
    }
}
