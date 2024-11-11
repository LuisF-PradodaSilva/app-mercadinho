package com.mercadinho.resources;

import com.mercadinho.domains.Produto;
import com.mercadinho.domains.dtos.ProdutoDTO;
import com.mercadinho.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
@Tag(name = "Produtos", description = "API para gerenciamento de produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista com todos os produtos cadastrados.")
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto com base no ID fornecido.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable int id) {
        Produto obj = this.produtoService.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @Operation(summary = "Criar um novo produto", description = "Cria um novo produto com base nos dados fornecidos.")
    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO objDto) {
        Produto newObj = produtoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualizar produto", description = "Atualiza os dados do produto.")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable int id, @Valid @RequestBody ProdutoDTO objDto) {
        Produto obj = produtoService.update(id, objDto);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @Operation(summary = "Deletar produto", description = "Deleta um produto com base no ID fornecido.")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> delete(@PathVariable int id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
