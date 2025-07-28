package br.com.senai.aula.controller;

import br.com.senai.aula.dto.UsuarioDTO;
import br.com.senai.aula.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody UsuarioDTO dto) {
        service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listar();
    }
}
