package com.patrick.gesplanbakend.services;

import com.patrick.gesplanbakend.dto.FornecedorTelefoneDto;
import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.repositories.FornecedoresTelefoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FornecedorTelefoneService {

    FornecedoresTelefoneRepository fornecedoresTelefoneRepository;

    public List<FornecedoresTelefone> buscarTodosTelefonesDosFornecedore(long FornecedorId){
        List<FornecedoresTelefone> telefones = fornecedoresTelefoneRepository.findFornecedoresTelefonesByFornecedoresId(FornecedorId);
        return telefones;
    }

    public List<FornecedoresTelefone> buscarTelefonesDosFornecedoresTelId(long FornecedorId){
        // Busca o telefone dos fornecedores filtrando pelo id do telefone

        List<FornecedoresTelefone> telefones = fornecedoresTelefoneRepository.findFornecedoresTelefonesByFornecedoresId(FornecedorId);
        return telefones;
    }

    public FornecedoresTelefone atualizarTelefone(long fornecedorId, long telefoneId, FornecedorTelefoneDto fornecedorTelefoneDto){
        FornecedoresTelefone fornecedoresTelefoneAttualizado =
                fornecedoresTelefoneRepository.findFornecedoresTelefonesByFornecedoresIdAndTelId(fornecedorId, telefoneId);

        fornecedoresTelefoneAttualizado.setNumeroTelefone(fornecedorTelefoneDto.getNumeroTelefone());

        return fornecedoresTelefoneRepository.save(fornecedoresTelefoneAttualizado);
    }

}
