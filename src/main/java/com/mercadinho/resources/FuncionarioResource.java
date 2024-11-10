package com.mercadinho.resources;

import com.mercadinho.domains.Funcionario;
import com.mercadinho.domains.dtos.FuncionarioDTO;
import com.mercadinho.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        Funcionario obj = this.funcionarioService.findById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public  ResponseEntity<FuncionarioDTO> findByCpf(@PathVariable String cpf) {
        Funcionario obj = this.funcionarioService.findByCpf(cpf);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario newObj = funcionarioService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario obj = funcionarioService.update(id, objDto);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }
}
