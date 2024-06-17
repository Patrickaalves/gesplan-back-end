package com.patrick.gesplanbakend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(nullable = false, name = "numero_telefone")
    private String numeroTelefone;

    @ManyToOne
    @JoinColumn(name = "fornecedores_id")
    @JsonIgnoreProperties({"nome", "email", "tipoDeFornecedor", "observacao", "fornecedoresTelefones"})
    private Fornecedores fornecedores;

}
