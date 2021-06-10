package br.edu.infnet.sgi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sgi.dtos.LoginDto;
import br.edu.infnet.sgi.dtos.TokenDto;
import br.edu.infnet.sgi.dtos.UsuarioDto;
import br.edu.infnet.sgi.services.TokenService;
import br.edu.infnet.sgi.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody @Validated LoginDto loginDto) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password);
		
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		String token = tokenService.generateToken(authentication);
		
		TokenDto tokenDto = new TokenDto("Bearer", token);
		return ResponseEntity.ok(tokenDto);
	  }	  
	
	@PostMapping("/usuario")
	public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto novoUsuario) {
	    return usuarioService.criarUsuario(novoUsuario);
	  }	  
	  
	@GetMapping("/usuario/{id}")
	public UsuarioDto buscarUsuario(@PathVariable long id) {
	    
		return usuarioService.buscarUsuario(id);
	}	  

	@PutMapping("/usuario/{id}")
	public UsuarioDto atualizarUsuario(@RequestBody UsuarioDto usuarioAtualizado, @PathVariable long id) {
	    
		return usuarioService.atualizarUsuario(usuarioAtualizado, id);
	}

	@DeleteMapping("/usuario/{id}")
	void deletarUsuario(@PathVariable long id) {
		usuarioService.deletarUsuario(id);
	}
}
