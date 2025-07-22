package br.com.senai.aula.controller;

import br.com.senai.aula.dto.PessoaDTO;
import br.com.senai.aula.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> criar(@RequestBody PessoaDTO pessoa) {
        PessoaDTO salva = pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<PessoaDTO> listar() {
        return pessoaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email")
    public PessoaDTO buscarPorEmail(@RequestParam String email) {
        return pessoaService.buscarPorEmail(email);
    }

    @GetMapping("/nome")
    public List<PessoaDTO> buscarPorNome(@RequestParam String nome) {
        return pessoaService.buscarPorNome(nome);
    }

    @GetMapping("/nascimento-anterior")
    public List<PessoaDTO> buscarPorDataAnterior(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return pessoaService.buscarPorDataNascimentoAntes(data);
    }

    @GetMapping("/cpf")
    public PessoaDTO buscarPorCpfDoDocumento(@RequestParam String cpf) {
        return pessoaService.buscarPorCpfDoDocumento(cpf);
    }
}

