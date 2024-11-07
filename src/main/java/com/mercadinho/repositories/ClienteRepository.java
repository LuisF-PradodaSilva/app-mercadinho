package com.mercadinho.repositories;

import com.mercadinho.domains.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Pessoa, Long> {

}
