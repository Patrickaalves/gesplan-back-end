package com.patrick.gesplanbakend.services;

import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.repositories.FornecedoresTelefoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FornecedorTelefoneService {

    FornecedoresTelefoneRepository fornecedoresTelefoneRepository;

    public List<FornecedoresTelefone> buscarTelefonesDosFornecedore(long FornecedorId){
        List<FornecedoresTelefone> telefones = fornecedoresTelefoneRepository.findFornecedoresTelefonesByFornecedoresId(FornecedorId);
        return telefones;
    }

}
