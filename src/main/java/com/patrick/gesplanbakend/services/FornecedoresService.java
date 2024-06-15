package com.patrick.gesplanbakend.services;

import com.patrick.gesplanbakend.dto.FornecedoresDto;
import com.patrick.gesplanbakend.exceptions.ResourceNotFoundException;
import com.patrick.gesplanbakend.models.Fornecedores;
import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.repositories.FornecedoresRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class FornecedoresService {
    private FornecedoresRepository fornecedoresRepository;

    @Transactional
    public Fornecedores criarFornecedores(FornecedoresDto fornecedoresDto) {
        // Validação para os requisitos de obrigatoriedade dos campos
        validarFornecedores(fornecedoresDto);

        Fornecedores fornecedores = new Fornecedores();
        fornecedores.setNome(fornecedoresDto.getNome());
        fornecedores.setEmail(fornecedoresDto.getEmail());

        Set<FornecedoresTelefone> telefones = fornecedoresDto.getTelefones();
        for (FornecedoresTelefone telefone : telefones) {
            // Validar se o telefone não esta nulo
            if(telefone.getNumeroTelefone() == null){
                throw new ResourceNotFoundException("O campo telefone esta nulo");
            }
            telefone.setFornecedores(fornecedores);
        }
        fornecedores.setFornecedoresTelefones(telefones);

        fornecedores.setTipoDeFornecedor(fornecedoresDto.getTipoDeFornecedor());
        fornecedores.setObservacao(fornecedoresDto.getObservacao());

        return fornecedoresRepository.save(fornecedores);
    }

    public void validarFornecedores(FornecedoresDto fornecedoresDto) {
        if (fornecedoresDto.getNome() == null) {
            throw new ResourceNotFoundException("O campo nome esta nulo");
        } else if (fornecedoresDto.getEmail() == null) {
            throw new ResourceNotFoundException("O campo email esta nulo");
        }else if (fornecedoresDto.getTipoDeFornecedor() == null) {
            throw new ResourceNotFoundException("O campo tipo de fornecedor esta nulo");
        }
    }

    public Fornecedores buscarFornecedorPorId(Long fornecedorId) {

        // Caso não encontre o Fornecedor, dispara a exception com uma mensagem mais detalhada
        Fornecedores buscarFornecedorPorId = fornecedoresRepository.findById(fornecedorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Feito a busca pelo id " + fornecedorId + " e nao foi encontrado nenhum fornecedor para o" +
                                " respectivo id"
                ));
        return buscarFornecedorPorId;
    }

    public Page<Fornecedores> buscarTodosOsFornecedores(Pageable pageable){

        Page<Fornecedores> listaFornecedor = fornecedoresRepository.findAll(pageable);

        return listaFornecedor;
    }

    public Fornecedores AtualizarFornecedores(long fornecedorId,FornecedoresDto fornecedoresDto) {

        Fornecedores fornecedores = buscarFornecedorPorId(fornecedorId);

        fornecedores.setNome(fornecedoresDto.getNome());
        fornecedores.setEmail(fornecedoresDto.getEmail());
        fornecedores.setTipoDeFornecedor(fornecedoresDto.getTipoDeFornecedor());
        fornecedores.setObservacao(fornecedoresDto.getObservacao());

        return fornecedoresRepository.save(fornecedores);
    }

    public void excluirFornecedor(long id){
        Fornecedores fornecedores = buscarFornecedorPorId(id);
        fornecedoresRepository.deleteById(id);
    }
}
