package br.edu.infnet.sgi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sgi.dtos.EventoDto;
import br.edu.infnet.sgi.services.EventoService;

@RestController
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@PostMapping("/eventos")
	  EventoDto cadastrarEvento(@RequestBody EventoDto novoEvento) {
	    return eventoService.criarEvento(novoEvento);
	  }	  
	  
	  @GetMapping("/eventos/{id}")
	  EventoDto buscarEvento(@PathVariable long id) {
	    
	    return eventoService.buscarEvento(id);
	  }
	  
	  @GetMapping("/eventos/{nome}")
	  List<EventoDto> buscarPorNome(@PathVariable String nome) {
	    
	    return eventoService.buscarEventoPorNome(nome);
	  }
	  
	  @GetMapping("/eventos/{tipo}")
	  List<EventoDto> buscarPorTipo(@PathVariable String tipo) {
	    
	    return eventoService.buscarEventosPorTipo(tipo);
	  }
	  
	  @GetMapping("/eventos/historico/{id}")
	  List<EventoDto> pesquisarHistorico(@PathVariable long id) {
	    
	    return eventoService.consultarHistorico(id);
	  }

	  @PutMapping("/eventos/{id}")
	  EventoDto atualizarEvento(@RequestBody EventoDto eventoAtualizado, @PathVariable long id) {
	    
	    return eventoService.atualizarEvento(eventoAtualizado, id);
	  }

	  @DeleteMapping("/eventos/{id}")
	  void deletarEvento(@PathVariable long id) {
	    eventoService.deletarEvento(id);
	  }
}
