package com.mercadinho.services;

import com.mercadinho.domains.Produto;
import com.mercadinho.domains.Venda;
import com.mercadinho.domains.dtos.ProdutoDTO;
import com.mercadinho.repositories.ProdutoRepository;
import com.mercadinho.repositories.VendaRepository;
import com.mercadinho.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaService vendaService;

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
    }

    public Produto findById(int id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado no sistema! ID: " + id));
    }

    private Produto newProduto(ProdutoDTO objDto) {
        Venda venda = vendaService.findById(objDto.getVenda());

        Produto produto = new Produto();

        if (objDto.getId() != 0) {
            produto.setId(objDto.getId());
        }

        produto.setVenda(venda);
        produto.setNomeProduto(objDto.getNomeProduto());
        produto.setDescricao(objDto.getDescricao());
        produto.setValorCompra(objDto.getValorCompra());
        produto.setValorVenda(objDto.getValorVenda());
        produto.setUnidadeMedida(objDto.getUnidadeMedida());
        produto.setTipoProduto(objDto.getTipoProduto());

        return produto;
    }

    public Produto create(ProdutoDTO ProdutoDto) {
        return produtoRepository.save(newProduto(ProdutoDto));
    }
}
