package br.edu.infnet.sgi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sgi.models.Organizador;
import br.edu.infnet.sgi.services.OrganizadorService;

@RestController
public class OrganizadorController {

	@Autowired
	private OrganizadorService organizadorService;
	
	@PostMapping("/organizador")
	Organizador cadastrarOrganizador(@RequestBody Organizador novoOrganizador) {
	    return organizadorService.criarOrganizador(novoOrganizador);
	  }	  
	  
	  @GetMapping("/organizador/{id}")
	  Organizador buscarOrganizador(@PathVariable long id) {
	    
	    return organizadorService.buscarOrganizador(id);
	  }
	  

	  @PutMapping("/organizador/{id}")
	  Organizador atualizarOrganizador(@RequestBody Organizador organizadorAtualizado, @PathVariable long id) {
	    
	    return organizadorService.atualizarOrganizador(organizadorAtualizado);
	  }

	  @DeleteMapping("/organizador/{id}")
	  void deletarOrganizador(@PathVariable long id) {
		  organizadorService.deletarOrganizador(id);
	  }
}
