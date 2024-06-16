package com.patrick.gesplanbakend.controllers;

import com.patrick.gesplanbakend.dto.FornecedorTelefoneDto;
import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.services.FornecedorTelefoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fornecedortelefone")
public class FornecedorTelefoneController {
    FornecedorTelefoneService fornecedorTelefoneService;

    @PostMapping("{id}")
    public ResponseEntity<FornecedoresTelefone> criarTelefone(@PathVariable long id, @RequestBody FornecedorTelefoneDto telefone) {
        FornecedoresTelefone FornecedorTelefoneCriado = fornecedorTelefoneService.criartelefone(id, telefone);
        return new ResponseEntity<>(FornecedorTelefoneCriado, HttpStatus.CREATED);
    }

    // Com base no id de forncedor, vai ser retornado todos os telefones ligados ao id do fornecedor
    @GetMapping("/fornecedor/{id}")
    public ResponseEntity<List<FornecedoresTelefone>> buscarTelefoneDosFornecedor(@PathVariable long id) {
        List<FornecedoresTelefone> listaTelefoneFornecedores = fornecedorTelefoneService.buscarTelefonesDosFornecedoresTelId(id);
        return ResponseEntity.ok(listaTelefoneFornecedores);
    }

    // Atualiza valor do campo telefone
    @PutMapping("/atualizarTelefone")
    public ResponseEntity<FornecedoresTelefone> atualizarTelefone(@RequestParam long idFornecedor,
                                                                  @RequestParam long idTelefone,
                                                                  @RequestBody FornecedorTelefoneDto fornecedorTelefoneDto) {
        FornecedoresTelefone fornecedoresTelefoneAtt = fornecedorTelefoneService.atualizarTelefone(idFornecedor,
                                                                                                   idTelefone,
                                                                                                   fornecedorTelefoneDto);
        return ResponseEntity.ok(fornecedoresTelefoneAtt);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarTelefone(@PathVariable long id) {
        fornecedorTelefoneService.deletarFornecedorTelefonePorIdTelefone(id);
        return ResponseEntity.ok("O telefone relacionado ao id " + id + " foi deletado com sucesso");
    }
}
