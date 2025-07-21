package br.com.senai.aula.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private LocalDate dataNascimento;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Documento documento;

    // getters, setters, toString
}

