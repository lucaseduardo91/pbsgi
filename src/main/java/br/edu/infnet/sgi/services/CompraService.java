package br.edu.infnet.sgi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.models.Compra;

@Service
public class CompraService {

	@Autowired
	private IngressoService ingressoService;
	
	public Compra processarCompra(Compra compra)
	{
		ingressoService.verificarDisponibilidade(null);
		// chamar método do repositório para salvar compra
		
		return new Compra();
	}
}
