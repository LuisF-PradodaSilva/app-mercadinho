package com.mercadinho.domains;

import java.time.LocalDate;
import java.util.Set;

public class Cliente extends Pessoa {

    public Cliente() {
        super();
    }

    public Cliente(Set<Integer> tipoPessoa, LocalDate dataCadastro, String cpf, String nomePessoa, Long id) {
        super(tipoPessoa, dataCadastro, cpf, nomePessoa, id);
    }

}
