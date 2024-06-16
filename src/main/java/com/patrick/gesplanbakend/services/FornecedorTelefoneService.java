package com.patrick.gesplanbakend.services;

import com.patrick.gesplanbakend.dto.FornecedorTelefoneDto;
import com.patrick.gesplanbakend.models.Fornecedores;
import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.repositories.FornecedoresTelefoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FornecedorTelefoneService {

    FornecedoresTelefoneRepository fornecedoresTelefoneRepository;
    FornecedoresService fornecedoresService;

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

    public void deletarFornecedor(long idTelefone) {
        fornecedoresTelefoneRepository.deleteById(idTelefone);
    }

    public FornecedoresTelefone criartelefone(long idFornecedor,FornecedorTelefoneDto fornecedorTelefoneDto){

        FornecedoresTelefone fornecedoresTelefone = new FornecedoresTelefone();

        fornecedoresTelefone.setNumeroTelefone(fornecedorTelefoneDto.getNumeroTelefone());
        Fornecedores fornecedores = fornecedoresService.buscarFornecedorPorId(idFornecedor);

        fornecedoresTelefone.setFornecedores(fornecedores);

        return fornecedoresTelefoneRepository.save(fornecedoresTelefone);
    }
}
