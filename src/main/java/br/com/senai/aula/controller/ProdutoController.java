package br.com.senai.aula.controller;

import br.com.senai.aula.dto.ProdutoFiltroDTO;
import br.com.senai.aula.model.Produto;
import br.com.senai.aula.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<Produto> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) Double precoMin,
            @RequestParam(required = false) Double precoMax,
            Pageable pageable
    ) {
        ProdutoFiltroDTO filtro = new ProdutoFiltroDTO();
        filtro.setNome(nome);
        filtro.setDescricao(descricao);
        filtro.setCategoria(categoria);
        filtro.setPrecoMin(precoMin);
        filtro.setPrecoMax(precoMax);

        return produtoService.listarComFiltros(filtro, pageable);
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto salvo = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
