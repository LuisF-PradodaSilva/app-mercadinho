package com.mercadinho.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente extends Pessoa {

    @OneToMany(mappedBy = "cliente")
    List<Venda> vendas = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(String cpf, String nomePessoa, Long id) {
        super(cpf, nomePessoa, id);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
