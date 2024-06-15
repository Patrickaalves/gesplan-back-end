package com.patrick.gesplanbakend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_fornecedores_telefone")
public class FornecedoresTelefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "numero_telefone", unique = true)
    private String numeroTelefone;

    @ManyToOne
    @JoinColumn(name = "fornecedores_id")
    private Fornecedores fornecedores;

}
