package br.edu.infnet.sgi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sgi.dtos.UsuarioDto;
import br.edu.infnet.sgi.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto novoUsuario) {
	    return usuarioService.criarUsuario(novoUsuario);
	  }	  
	  
	  @GetMapping("/usuario/{id}")
	  UsuarioDto buscarUsuario(@PathVariable long id) {
	    
	    return usuarioService.buscarUsuario(id);
	  }	  

	  @PutMapping("/usuario/{id}")
	  UsuarioDto atualizarUsuario(@RequestBody UsuarioDto usuarioAtualizado, @PathVariable long id) {
	    
	    return usuarioService.atualizarUsuario(usuarioAtualizado, id);
	  }

	  @DeleteMapping("/usuario/{id}")
	  void deletarUsuario(@PathVariable long id) {
		  usuarioService.deletarUsuario(id);
	  }
}
