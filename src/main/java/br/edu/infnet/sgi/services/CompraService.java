package br.edu.infnet.sgi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.dtos.CompraDto;
import br.edu.infnet.sgi.models.Compra;
import br.edu.infnet.sgi.repositories.CompraRepository;

@Service
public class CompraService {
		
	@Autowired
	CompraRepository compraRepository;
	
	@Autowired
	EntityConverterService conversor;
	
	public CompraDto processarCompra(CompraDto compraDto)
	{		
		Compra compra = conversor.converterDtoParaCompra(compraDto);
		compra.getEvento().setId(compraDto.evento.id);
		compra.getCliente().setId(compraDto.cliente.id);
		
		compraRepository.save(compra);
		
		return compraDto;
	}
}
