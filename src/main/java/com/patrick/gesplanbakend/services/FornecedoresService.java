package com.patrick.gesplanbakend.services;

import com.patrick.gesplanbakend.dto.FornecedoresDto;
import com.patrick.gesplanbakend.models.Fornecedores;
import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.repositories.FornecedoresRepository;
import com.patrick.gesplanbakend.repositories.FornecedoresTelefoneRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class FornecedoresService {
    private FornecedoresRepository fornecedoresRepository;
    private FornecedoresTelefoneRepository  fornecedoresTelefoneRepository;

    @Transactional
    public Fornecedores criarFornecedores(FornecedoresDto fornecedoresDto) {
        Fornecedores fornecedores = new Fornecedores();
        fornecedores.setNome(fornecedoresDto.getNome());
        fornecedores.setEmail(fornecedoresDto.getEmail());

        Set<FornecedoresTelefone> telefones = fornecedoresDto.getTelefones();
        for (FornecedoresTelefone telefone : telefones) {
            telefone.setFornecedores(fornecedores);
        }
        fornecedores.setFornecedoresTelefones(telefones);

        fornecedores.setTipoDeFornecedor(fornecedoresDto.getTipoDeFornecedor());
        fornecedores.setObservacao(fornecedoresDto.getObservacao());

        return fornecedoresRepository.save(fornecedores);
    }

}
