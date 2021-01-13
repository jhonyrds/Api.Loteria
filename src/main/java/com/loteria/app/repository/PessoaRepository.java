package com.loteria.app.repository;

import com.loteria.app.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findById (Long id);
    boolean existsByEmail (String email);
}
