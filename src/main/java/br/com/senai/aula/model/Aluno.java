package br.com.senai.aula.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String matricula;

    private String cursoPrincipal;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<AlunoCurso> alunoCursos = new ArrayList<>();

    // getters, setters, toString
}
