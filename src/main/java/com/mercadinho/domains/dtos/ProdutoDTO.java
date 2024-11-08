package com.mercadinho.domains.dtos;

import com.mercadinho.domains.Produto;

import java.util.UUID;

public class ProdutoDTO {

    private int id;
    private String nomeProduto;
    private String descricao;
    private double valorCompra;
    private double valorVenda;
    private String unidadeMedida;
    private UUID venda;
    private String tipoProduto;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nomeProduto = produto.getNomeProduto();
        this.descricao = produto.getDescricao();
        this.valorCompra = produto.getValorCompra();
        this.valorVenda = produto.getValorVenda();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.venda = produto.getVenda().getId();
        this.tipoProduto = produto.getTipoProduto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public UUID getVenda() {
        return venda;
    }

    public void setVenda(UUID venda) {
        this.venda = venda;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
}
