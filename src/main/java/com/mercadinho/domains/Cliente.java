package com.mercadinho.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa {

    public Cliente() {
        super();
    }

    public Cliente(Set<Integer> tipoPessoa, LocalDate dataCadastro, String cpf, String nomePessoa, Long id) {
        super(tipoPessoa, dataCadastro, cpf, nomePessoa, id);
    }

}
