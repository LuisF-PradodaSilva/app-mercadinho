package com.mercadinho.resources;

import com.mercadinho.domains.Produto;
import com.mercadinho.domains.dtos.ProdutoDTO;
import com.mercadinho.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable int id) {
        Produto obj = this.produtoService.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO objDto) {
        Produto newObj = produtoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable int id, @Valid @RequestBody ProdutoDTO objDto) {
        Produto obj = produtoService.update(id, objDto);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> delete(@PathVariable int id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
