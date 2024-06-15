package com.patrick.gesplanbakend.repositories;

import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FornecedoresTelefoneRepository extends JpaRepository<FornecedoresTelefone, Long> {

    @Query("SELECT ft FROM FornecedoresTelefone ft WHERE ft.fornecedores.id = :id")
    List<FornecedoresTelefone> findFornecedoresTelefonesByFornecedoresId(@Param("id") Long id);
}
