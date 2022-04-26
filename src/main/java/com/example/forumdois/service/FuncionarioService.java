package com.example.forumdois.service;

import com.example.forumdois.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FuncionarioService {

    public List<Funcionario> obterTodos();
    public ResponseEntity<Funcionario> obterPorCodigo(String codigo);
    public Funcionario criar(Funcionario funcionario);
    public ResponseEntity<Object> deletar(String codigo);
    public Funcionario alterarDadosPorCodigo(String codigo, Funcionario funcionario);

}
