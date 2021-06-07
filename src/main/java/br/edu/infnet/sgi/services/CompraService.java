package br.edu.infnet.sgi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.dtos.CompraDto;
import br.edu.infnet.sgi.models.Compra;
import br.edu.infnet.sgi.models.Evento;
import br.edu.infnet.sgi.repositories.CompraRepository;
import br.edu.infnet.sgi.repositories.EventoRepository;

@Service
public class CompraService {
		
	@Autowired
	CompraRepository compraRepository;
	
	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	EntityConverterService conversor;
	
	public CompraDto processarCompra(CompraDto compraDto)
	{		
		Compra compra = conversor.converterDtoParaCompra(compraDto);
		
		compra.getCliente().setId(compraDto.cliente.id);
		
		Evento evento = eventoRepository.findById(compraDto.evento.id).get();
		int ingressosVendidos = evento.getIngressosVendidos() + compra.getQtdIngressos();
		evento.setIngressosVendidos(ingressosVendidos);
		
		compra.setEvento(evento);
		
		compraRepository.save(compra);
		eventoRepository.save(evento);
		
		return compraDto;
	}
}
