package com.mercadinho.repositories;

import com.mercadinho.domains.Funcionario;
import com.mercadinho.domains.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByCpf(String cpf);
    Optional<Pessoa> findByNomePessoa(String nomePessoa);
}
