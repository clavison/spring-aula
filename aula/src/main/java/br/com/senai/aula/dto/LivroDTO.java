package br.com.senai.aula.dto;

public class LivroDTO {
    private int id;
    private String titulo;
    private int paginas;

    public LivroDTO(int id, String titulo, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.paginas = paginas;
    }
    //gets

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginas() {
        return paginas;
    }
}
