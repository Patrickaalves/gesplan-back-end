package com.patrick.gesplanbakend.dto;

import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedoresDto {
    String nome;
    String email;
    Set<FornecedoresTelefone> telefones;
    String tipoDeFornecedor;
    String observacao;
}
