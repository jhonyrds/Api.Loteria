package com.loteria.app.repository;

import com.loteria.app.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {

    @Query(value = "SELECT * FROM Aposta WHERE pessoaId = :id", nativeQuery = true)
    List<Aposta> findBuscarApostas(@Param("id") Long id);

    List<Aposta> findByPessoaId(long id);
}
