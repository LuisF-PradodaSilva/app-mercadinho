package com.mercadinho.domains.dtos;

import com.mercadinho.domains.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class ProdutoDTO {

    private int id;

    @NotNull(message = "O nome do produto não pode ser nulo!")
    @NotBlank(message = "O nome do produto não pode ser em branco!")
    private String nomeProduto;

    @NotNull(message = "A descrição do produto não pode ser nulo!")
    @NotBlank(message = "A descrição do produto não pode ser em branco!")
    private String descricao;

    @Positive(message = "O valor de compra não pode ser R$0,00 ou negativo!")
    private double valorCompra;

    @Positive(message = "O valor de venda não pode ser R$0,00 ou negativo!")
    private double valorVenda;

    @NotNull(message = "A unidade de medida não pode ser nulo!")
    @NotBlank(message = "A unidade de medida não pode ser em branco!")
    private String unidadeMedida;
    private UUID venda;

    @NotNull(message = "O tipo do produto não pode ser nulo!")
    @NotBlank(message = "O tipo do produto não pode ser em branco!")
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
