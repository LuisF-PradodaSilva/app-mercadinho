package com.mercadinho.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadinho.domains.Venda;

import java.time.LocalDate;
import java.util.UUID;

public class VendaDTO {

    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda = LocalDate.now();
    private double valorTotal;
    private Long cliente;

    public VendaDTO(){
    }

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.dataVenda = venda.getDataVenda();
        this.valorTotal = venda.getValorTotal();
        this.cliente = venda.getCliente().getId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

}
