package com.patrick.gesplanbakend.controllers;

import com.patrick.gesplanbakend.dto.FornecedoresDto;
import com.patrick.gesplanbakend.models.Fornecedores;
import com.patrick.gesplanbakend.services.FornecedoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<Fornecedores> buscarFornecedorPorId(@PathVariable Long id){
        Fornecedores buscarFornecedorPorId = fornecedoresService.buscarFornecedorPorId(id);
        return ResponseEntity.ok(buscarFornecedorPorId);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedores>> buscarTodosFornecedores(){
        List<Fornecedores> buscarTodosOsFornecedores = fornecedoresService.buscarTodosOsFornecedores();
        return ResponseEntity.ok(buscarTodosOsFornecedores);
    }


}
