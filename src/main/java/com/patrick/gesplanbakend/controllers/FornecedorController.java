package com.patrick.gesplanbakend.controllers;

import com.patrick.gesplanbakend.dto.FornecedoresDto;
import com.patrick.gesplanbakend.models.Fornecedores;
import com.patrick.gesplanbakend.services.FornecedoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/desafio")
public class FornecedorController {

    FornecedoresService fornecedoresService;

    @PostMapping
    public ResponseEntity<Fornecedores> criarFornecedor(@RequestBody FornecedoresDto fornecedorDto){
        Fornecedores salvarFornecedor = fornecedoresService.criarFornecedores(fornecedorDto);
        return new ResponseEntity<>(salvarFornecedor, HttpStatus.CREATED);
    }
}
