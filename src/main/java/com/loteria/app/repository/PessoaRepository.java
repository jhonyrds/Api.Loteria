package com.loteria.app.repository;

import com.loteria.app.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    boolean existsByEmail (String email);
}
