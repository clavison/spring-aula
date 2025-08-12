package br.com.senai.aula.controller;

import br.com.senai.aula.model.Produto;
import br.com.senai.aula.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<Produto> getProdutos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        return produtoService.getProdutosPaginados(page, size);
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto salvo = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
