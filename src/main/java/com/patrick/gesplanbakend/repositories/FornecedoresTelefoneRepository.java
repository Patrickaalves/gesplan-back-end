package com.patrick.gesplanbakend.repositories;

import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FornecedoresTelefoneRepository extends JpaRepository<FornecedoresTelefone, Long> {

    @Query(value = "SELECT ft FROM FornecedoresTelefone FT WHERE FT.fornecedores.id = :id", nativeQuery = true)
    List<FornecedoresTelefone> findFornecedoresTelefonesByFornecedoresId(@Param("id") Long fornecedoresId);
}
