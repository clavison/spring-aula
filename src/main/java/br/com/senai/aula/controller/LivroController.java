package br.com.senai.aula.controller;

import br.com.senai.aula.dto.LivroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private ArrayList<LivroDTO> livros = new ArrayList<LivroDTO>();

    private int nextId = 1;

    @PostMapping
    public ResponseEntity<LivroDTO> criarLivro(@RequestBody LivroDTO livroDTO) {
        LivroDTO novoLivro = new LivroDTO(nextId++, livroDTO.getTitulo(), livroDTO.getPaginas());
        livros.add(novoLivro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros() {
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> buscarLivroPorId(@PathVariable int id) {
        for (LivroDTO livro : livros) {
            if (livro.getId() == id) {
                return ResponseEntity.ok(livro);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // UPDATE - PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizarLivro(@PathVariable int id, @RequestBody LivroDTO livro) {
        for (int i = 0; i < livros.size(); i++) {
            LivroDTO l = livros.get(i);
            if (l.getId() == id) {
                LivroDTO novoLivro = new LivroDTO(id, livro.getTitulo(), livro.getPaginas());
                livros.set(i, novoLivro);
                return ResponseEntity.ok(novoLivro);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // DELETE - DELETE /{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable int id) {
        boolean removido = livros.removeIf(livro -> livro.getId() == id);
        if (removido) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
