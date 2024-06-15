package com.patrick.gesplanbakend.controllers;

import com.patrick.gesplanbakend.models.FornecedoresTelefone;
import com.patrick.gesplanbakend.repositories.FornecedoresTelefoneRepository;
import com.patrick.gesplanbakend.services.FornecedorTelefoneService;
import com.patrick.gesplanbakend.services.FornecedoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fornecedortelefone")
public class FornecedorTelefoneController {
    FornecedorTelefoneService fornecedorTelefoneService;

    @GetMapping("/fornecedor/{id}")
    public ResponseEntity<List<FornecedoresTelefone>> buscarTelefoneDosFornecedor(@PathVariable long id) {
        List<FornecedoresTelefone> telefones = fornecedorTelefoneService.buscarTelefonesDosFornecedore(id);
        return ResponseEntity.ok(telefones);
    }
}
