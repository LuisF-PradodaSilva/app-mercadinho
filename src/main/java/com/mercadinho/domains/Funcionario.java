package com.mercadinho.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Funcionario extends Pessoa {

    public Funcionario() {
        super();
    }

    public Funcionario(String cpf, String nomePessoa, Long id) {
        super(cpf, nomePessoa, id);
    }
    
}
