package com.patrick.gesplanbakend.repositories;

import com.patrick.gesplanbakend.models.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long>,
        PagingAndSortingRepository<Fornecedores, Long> {
}
