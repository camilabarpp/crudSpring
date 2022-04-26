package com.example.forumdois.service.impl;

import com.example.forumdois.model.Funcionario;
import com.example.forumdois.repository.FuncionarioRepository;
import com.example.forumdois.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public ResponseEntity<Funcionario> obterPorCodigo(String codigo) {
        Optional<Funcionario> funcionario=this.funcionarioRepository.findById(codigo);
        if (funcionario.isPresent()){
            return new ResponseEntity<Funcionario>(funcionario.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @Override
    public Funcionario criar(@Validated Funcionario funcionario) {

       return funcionarioRepository.save(funcionario);

    }
    @Override
    public ResponseEntity<Object> deletar(String codigo) {
        Optional<Funcionario> funcionarioExiste = this.funcionarioRepository.findById(codigo);
        if(funcionarioExiste.isPresent()) {
            this.funcionarioRepository.deleteById(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Funcionario alterarDadosPorCodigo(String codigo, Funcionario funcionario) {
        Optional<Funcionario> funcionarioAnterior= this.funcionarioRepository.findById(codigo);
        if(funcionarioAnterior.isPresent()){
            Funcionario funcionarioAlterar=funcionarioAnterior.get();
            funcionarioAlterar.setNome(funcionario.getNome());
            funcionarioAlterar.setIdade(funcionario.getIdade());
            funcionarioAlterar.setSalario(funcionario.getSalario());
            this.funcionarioRepository.save(funcionarioAlterar);

            return new ResponseEntity<Funcionario>(funcionarioAlterar, HttpStatus.OK).getBody();
        }
        else{
            return null;}
    }


}
