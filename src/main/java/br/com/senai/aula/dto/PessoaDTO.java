package br.com.senai.aula.dto;

import java.time.LocalDate;

public class PessoaDTO {
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private DocumentoDTO documento;

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, String email, LocalDate dataNascimento, DocumentoDTO documento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public DocumentoDTO getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDTO documento) {
        this.documento = documento;
    }
}
