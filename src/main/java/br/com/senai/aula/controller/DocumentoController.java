package br.com.senai.aula.controller;

import br.com.senai.aula.dto.DocumentoDTO;
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
    public ResponseEntity<DocumentoDTO> criar(@RequestBody DocumentoDTO documento) {
        DocumentoDTO salvo = documentoService.salvar(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<DocumentoDTO> listar() {
        return documentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTO> buscarPorId(@PathVariable Long id) {
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
    public DocumentoDTO buscarPorCpf(@RequestParam String cpf) {
        return documentoService.buscarPorCpf(cpf);
    }

    @GetMapping("/rg")
    public DocumentoDTO buscarPorRg(@RequestParam String rg) {
        return documentoService.buscarPorRg(rg);
    }

    @GetMapping("/pessoa-nome")
    public List<DocumentoDTO> buscarPorNomeDaPessoa(@RequestParam String nome) {
        return documentoService.buscarPorNomeDaPessoa(nome);
    }
}

