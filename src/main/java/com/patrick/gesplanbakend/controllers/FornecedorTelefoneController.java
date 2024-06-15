package com.patrick.gesplanbakend.controllers;

import com.patrick.gesplanbakend.dto.FornecedorTelefoneDto;
import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.services.FornecedorTelefoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fornecedortelefone")
public class FornecedorTelefoneController {
    FornecedorTelefoneService fornecedorTelefoneService;

    @GetMapping("/fornecedor/{id}")
    public ResponseEntity<List<FornecedoresTelefone>> buscarTelefoneDosFornecedor(@PathVariable long id) {
        List<FornecedoresTelefone> telefones = fornecedorTelefoneService.buscarTodosTelefonesDosFornecedore(id);
        return ResponseEntity.ok(telefones);
    }

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
        fornecedorTelefoneService.deletarFornecedor(id);
        return ResponseEntity.ok("O telefone relacionado ao id " + id + " foi deletado com sucesso");
    }


}
