package com.patrick.gesplanbakend.controllers;

import com.patrick.gesplanbakend.dto.FornecedoresDto;
import com.patrick.gesplanbakend.models.Fornecedores;
import com.patrick.gesplanbakend.services.FornecedoresService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    FornecedoresService fornecedoresService;

    @PostMapping
    public ResponseEntity<Fornecedores> criarFornecedor(@RequestBody FornecedoresDto fornecedorDto){
        Fornecedores salvarFornecedor = fornecedoresService.criarFornecedor(fornecedorDto);
        return new ResponseEntity<>(salvarFornecedor, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedores> buscarFornecedorPorId(@PathVariable Long id){
        Fornecedores buscarFornecedorPorId = fornecedoresService.buscarFornecedorPorId(id);
        return ResponseEntity.ok(buscarFornecedorPorId);
    }

    @GetMapping
    public ResponseEntity<Page<Fornecedores>> buscarTodosFornecedores(Pageable pageable){
        Page<Fornecedores> buscarTodosOsFornecedores = fornecedoresService.buscarTodosOsFornecedores(pageable);
        return ResponseEntity.ok(buscarTodosOsFornecedores);
    }

    @PutMapping("{id}")
    public ResponseEntity<Fornecedores> atualizarFornecedor(@PathVariable long id, @RequestBody FornecedoresDto fornecedorDto){
        Fornecedores fornecedorAtualizado = fornecedoresService.AtualizarFornecedor(id, fornecedorDto);
        return ResponseEntity.ok(fornecedorAtualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarFornecedor(@PathVariable long id){
        fornecedoresService.excluirFornecedor(id);
        return ResponseEntity.ok("Fornecedor: " + id + " excluido com sucesso");
    }
}
