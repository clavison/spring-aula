package br.com.senai.aula.controller;

import br.com.senai.aula.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Olá mundo SENAI";
    }

    @GetMapping("/usuario/generico")
    public UsuarioDTO getUsuarioGenerico() {
        UsuarioDTO usuarioDTO = new UsuarioDTO("Fulano", "fulano@gmail.com", "123456");
        return usuarioDTO;
    }

    @GetMapping("/usuario/request-param")
    public UsuarioDTO getUsuarioRequestParam(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(nome, email, senha);
        return usuarioDTO;
    }

    @GetMapping("/usuario/path-variable/{nome}/{email}/{senha}")
    public UsuarioDTO getUsuarioPathVariable(@PathVariable String nome, @PathVariable String email, @PathVariable String senha) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(nome, email, senha);
        return usuarioDTO;
    }

    @GetMapping("/usuario/request-body")
    public UsuarioDTO getUsuarioRequestBody(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioDTO;
    }

}
