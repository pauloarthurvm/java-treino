package br.com.coruja.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alunoId;

    @NotNull
    private String nome;

    private String email;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
