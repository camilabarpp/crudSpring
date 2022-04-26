package com.example.forumdois.controller;

import com.example.forumdois.model.Funcionario;
import com.example.forumdois.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
//teste
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos(){
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Funcionario> obterCodigo(@PathVariable(value = "codigo") String codigo){
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario){
        this.funcionarioService.criar(funcionario);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED).getBody();
    }

    @PutMapping("/{codigo}")
    public Funcionario alterarFuncionarioPeloId(@PathVariable(value = "codigo") String codigo,@RequestBody Funcionario funcionario){
        return this.funcionarioService.alterarDadosPorCodigo(codigo, funcionario);

    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable String codigo){
        this.funcionarioService.deletar(codigo);
    }



}
