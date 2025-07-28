package br.com.senai.aula.dto;

public class Usuario1DTO {

    private String nome;
    private String email;
    private String senha;

    public Usuario1DTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
