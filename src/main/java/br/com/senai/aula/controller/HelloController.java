package br.com.senai.aula.controller;

import br.com.senai.aula.dto.Usuario1DTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Olá mundo SENAI";
    }

    @GetMapping("/usuario/generico")
    public Usuario1DTO getUsuarioGenerico() {
        Usuario1DTO usuario1DTO = new Usuario1DTO("Fulano", "fulano@gmail.com", "123456");
        return usuario1DTO;
    }

    @GetMapping("/usuario/request-param")
    public Usuario1DTO getUsuarioRequestParam(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Usuario1DTO usuario1DTO = new Usuario1DTO(nome, email, senha);
        return usuario1DTO;
    }

    @GetMapping("/usuario/path-variable/{nome}/{email}/{senha}")
    public Usuario1DTO getUsuarioPathVariable(@PathVariable String nome, @PathVariable String email, @PathVariable String senha) {
        Usuario1DTO usuario1DTO = new Usuario1DTO(nome, email, senha);
        return usuario1DTO;
    }

    @GetMapping("/usuario/request-body")
    public Usuario1DTO getUsuarioRequestBody(@RequestBody Usuario1DTO usuario1DTO) {
        return usuario1DTO;
    }

}
