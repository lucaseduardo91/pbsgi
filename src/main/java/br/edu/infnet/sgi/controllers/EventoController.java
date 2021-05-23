package br.edu.infnet.sgi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sgi.models.Evento;
import br.edu.infnet.sgi.services.EventoService;

@RestController
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@PostMapping("/eventos")
	  Evento cadastrarEvento(@RequestBody Evento novoEvento) {
	    return eventoService.criarEvento(novoEvento);
	  }	  
	  
	  @GetMapping("/eventos/{id}")
	  Evento buscarEvento(@PathVariable long id) {
	    
	    return eventoService.buscarEvento(id);
	  }
	  
	  @GetMapping("/eventos/historico/{id}")
	  Evento pesquisarHistorico(@PathVariable long id) {
	    
	    return eventoService.consultarHistorico(id);
	  }

	  @PutMapping("/eventos/{id}")
	  Evento atualizarEvento(@RequestBody Evento eventoAtualizado, @PathVariable long id) {
	    
	    return eventoService.atualizarEvento(eventoAtualizado);
	  }

	  @DeleteMapping("/eventos/{id}")
	  void deletarEvento(@PathVariable long id) {
	    eventoService.deletarEvento(id);
	  }
}
