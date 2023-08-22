package br.com.coruja.application.controller;

//import org.springframework.security.access.prepost.PreAuthorize;

import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {

    @RequestMapping("/api/ola")
    public String index() {
        return "Olá Mundo!";
    }

    @Autowired
    AlunoRepository alunoRepository;

//  Ter o método find, list, save, update e delete.

    //  find deve buscar por um aluno específico recebendo o ID no path param - GET
//  retornar 200 como status code
//  caso não exista um aluno o valor retornado deve ser 404
    @GetMapping("/aluno")
    public ResponseEntity<Aluno> getAluno(@RequestParam String id) {
        try {
            Long longId = Long.parseLong(id);
            Optional<Aluno> aluno = alunoRepository.findById(longId);
            if (aluno.isPresent()) {
                return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
            }
            System.out.println("Nao pode encontrar aluno com ID=" + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //  list deve listar todos os alunos - GET
//  retornar 200 como status code
//  deve retornar uma coleção vazia com o status code 200
    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> getAlunos() {
        List<Aluno> aluno = alunoRepository.findAll();
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    //  save deve salvar um novo aluno - POST
//  retornar 201 como status code
    @PostMapping("/novoAluno")
    public ResponseEntity<Aluno> novoAluno(@RequestBody Aluno novoAluno) {
        Aluno aluno = alunoRepository.save(novoAluno);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    //  put deve atualizar todos os atributos de um aluno recebendo o ID no path param - PUT
//  retornar 200 como status code
    @PutMapping("/atualizarAluno/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable String id, @RequestBody Aluno alunoAtualizado) {
        Optional<Aluno> aluno = alunoRepository.findById(Long.parseLong(id));
        if (aluno.isPresent()) {
            aluno.get().setNome(alunoAtualizado.getNome());
            aluno.get().setEmail(alunoAtualizado.getEmail());
            return new ResponseEntity<>(alunoRepository.save(aluno.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //  delete deve remover um aluno - DELETE
//  retornar 200 como status code
    @DeleteMapping("/deletarAluno/{id}")
    public ResponseEntity<Aluno> deletarAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}