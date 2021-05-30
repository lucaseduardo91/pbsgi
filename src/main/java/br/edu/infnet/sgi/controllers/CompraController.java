package br.edu.infnet.sgi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sgi.dtos.CompraDto;
import br.edu.infnet.sgi.services.CompraService;

@RestController
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@PostMapping("/compra")
	CompraDto cadastrarCompra(@RequestBody CompraDto novaCompra) {
	    return compraService.processarCompra(novaCompra);
	  }	  
}
