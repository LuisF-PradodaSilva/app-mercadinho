package com.mercadinho.domains;

import java.time.LocalDate;
import java.util.Set;

public class Funcionario extends Pessoa {

    public Funcionario() {
        super();
    }

    public Funcionario(Set<Integer> tipoPessoa, LocalDate dataCadastro, String cpf, String nomePessoa, Long id) {
        super(tipoPessoa, dataCadastro, cpf, nomePessoa, id);
    }
    
}
