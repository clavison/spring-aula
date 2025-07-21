package br.com.senai.aula.controller;

import br.com.senai.aula.model.Documento;
import br.com.senai.aula.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<Documento> criar(@RequestBody Documento documento) {
        Documento salvo = documentoService.salvar(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Documento> listar() {
        return documentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> buscarPorId(@PathVariable Long id) {
        return documentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        documentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cpf")
    public Documento buscarPorCpf(@RequestParam String cpf) {
        return documentoService.buscarPorCpf(cpf);
    }

    @GetMapping("/rg")
    public Documento buscarPorRg(@RequestParam String rg) {
        return documentoService.buscarPorRg(rg);
    }

    @GetMapping("/pessoa-nome")
    public List<Documento> buscarPorNomeDaPessoa(@RequestParam String nome) {
        return documentoService.buscarPorNomeDaPessoa(nome);
    }
}

