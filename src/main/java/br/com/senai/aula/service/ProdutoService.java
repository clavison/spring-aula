package br.com.senai.aula.service;

import br.com.senai.aula.dto.ProdutoFiltroDTO;
import br.com.senai.aula.dto.specifications.ProdutoSpecification;
import br.com.senai.aula.model.Produto;
import br.com.senai.aula.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> getProdutosPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produtoRepository.findAll(pageable);
    }

    public Page<Produto> listarComFiltros(ProdutoFiltroDTO filtro, Pageable pageable) {
        return produtoRepository.findAll(ProdutoSpecification.comFiltros(filtro), pageable);
    }

    public Produto create(Produto produto) {
        return  produtoRepository.save(produto);
    }
}
