package com.patrick.gesplanbakend.repositories;

import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FornecedoresTelefoneRepository extends JpaRepository<FornecedoresTelefone, Long> {

    // Retorna todos os telefones relacionados ao id de algum fornecedor
    @Query("SELECT ft FROM FornecedoresTelefone ft WHERE ft.fornecedores.id = :idForn")
    List<FornecedoresTelefone> findFornecedoresTelefonesByFornecedoresId(@Param("idForn") Long fornecedoresId);

    // Retorna o telefone relacionado ao id de algum fornecedor e o id de telefone especifico
    @Query("SELECT ft FROM FornecedoresTelefone ft WHERE ft.fornecedores.id = :idForn and ft.id = :idTel")
    FornecedoresTelefone findFornecedoresTelefonesByFornecedoresIdAndTelId(@Param("idForn") Long idFornecedor,
                                                                           @Param("idTel") long IdTelefone);
}
