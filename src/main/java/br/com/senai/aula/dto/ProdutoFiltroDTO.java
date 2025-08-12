package br.com.senai.aula.dto;

public class ProdutoFiltroDTO {

    private String nome;
    private String descricao;
    private String categoria;
    private Double precoMin;
    private Double precoMax;

    //gets e sets


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecoMin() {
        return precoMin;
    }

    public void setPrecoMin(Double precoMin) {
        this.precoMin = precoMin;
    }

    public Double getPrecoMax() {
        return precoMax;
    }

    public void setPrecoMax(Double precoMax) {
        this.precoMax = precoMax;
    }
}
