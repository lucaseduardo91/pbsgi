package br.edu.infnet.sgi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sgi.models.Cliente;
import br.edu.infnet.sgi.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cliente")
	Cliente cadastrarEvento(@RequestBody Cliente novoCliente) {
	    return clienteService.criarCliente(novoCliente);
	  }	  
	  
	  @GetMapping("/cliente/{id}")
	  Cliente buscarCliente(@PathVariable long id) {
	    
	    return clienteService.buscarCliente(id);
	  }
	  

	  @PutMapping("/cliente/{id}")
	  Cliente atualizarCliente(@RequestBody Cliente clienteAtualizado, @PathVariable long id) {
	    
	    return clienteService.atualizarCliente(clienteAtualizado);
	  }

	  @DeleteMapping("/cliente/{id}")
	  void deletarCliente(@PathVariable long id) {
		  clienteService.deletarCliente(id);
	  }
}
