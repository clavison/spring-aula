package br.com.senai.aula.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno_curso")
public class AlunoCurso {

    @EmbeddedId
    private AlunoCursoId id = new AlunoCursoId();

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private int semestre;

    // getters, setters, toString
}

