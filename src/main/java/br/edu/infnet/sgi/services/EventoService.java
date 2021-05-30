package br.edu.infnet.sgi.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.dtos.EventoDto;
import br.edu.infnet.sgi.dtos.UsuarioDto;
import br.edu.infnet.sgi.models.Evento;
import br.edu.infnet.sgi.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	EntityConverterService conversor;
	
	public EventoDto criarEvento(EventoDto novoEvento)
	{
		if(validarDadosEvento(novoEvento))
		{
			Evento evento = conversor.converterDtoParaEvento(novoEvento);
			eventoRepository.save(evento);
			return novoEvento;
		}				
		
		return null;
	}
	
	public EventoDto buscarEvento(long id)
	{
		Evento evento = eventoRepository.findById(id).get();
		
		return conversor.converterEventoParaDto(evento);
	}
	
	public List<EventoDto> buscarEventoPorNome(String nomeEvento)
	{
		List<Evento> eventos = eventoRepository.findByNome(nomeEvento);
		List<EventoDto> eventosDto = new ArrayList<EventoDto>();
		
		for(Evento evento : eventos)
		{
			eventosDto.add(conversor.converterEventoParaDto(evento));
		}
		
		return eventosDto;
	}
	
	public List<EventoDto> buscarEventosPorTipo(String tipoEvento)
	{
		List<Evento> eventos = eventoRepository.findByTipoEvento(tipoEvento);
		List<EventoDto> eventosDto = new ArrayList<EventoDto>();
		
		for(Evento evento : eventos)
		{
			eventosDto.add(conversor.converterEventoParaDto(evento));
		}
		
		return eventosDto;
	}
	
	public List<EventoDto> consultarHistorico(long id)
	{
		// Chamar método do repositório para buscar eventos passados com participação do usuário
		
		return new ArrayList<EventoDto>();
	}
	
	public EventoDto atualizarEvento(EventoDto eventoAtualizado, long id)
	{		
		Evento evento = eventoRepository.findById(id).get();
		
		evento.setId(id);
		evento.setNome(eventoAtualizado.nome);
		evento.setDescricao(eventoAtualizado.descricao);
		evento.setEndereco(eventoAtualizado.endereco);
		evento.setTipoEvento(eventoAtualizado.tipoEvento);
		evento.setIngressosVendidos(eventoAtualizado.ingressosVendidos);
		evento.setLotacao(eventoAtualizado.lotacao);
		evento.setPreco(eventoAtualizado.preco);
		evento.setOrganizador(conversor.converterDtoParaUsuario(eventoAtualizado.organizador));
		
		eventoRepository.save(evento);
		
		return eventoAtualizado;
	}
	
	public void deletarEvento(long id)
	{
		eventoRepository.deleteById(id);
	}
	
	private boolean validarDadosEvento(EventoDto evento) {
		String nome = evento.nome;
		String tipoEvento = evento.tipoEvento;
		String descricao = evento.descricao;
		int lotacao = evento.lotacao;
		String endereco = evento.endereco;
		UsuarioDto organizador = evento.organizador;
		BigDecimal preco = evento.preco;
		
		if(nome == null || nome.length() < 2 || nome.length() > 50)
			return false;
		
		if(tipoEvento == null || tipoEvento.length() < 2 || tipoEvento.length() > 20)
			return false;
		
		if(descricao == null || descricao.length() < 2 || descricao.length() > 50)
			return false;
		
		if(lotacao <= 0)
			return false;
		
		if(endereco == null || endereco.length() < 5 || endereco.length() > 80)
			return false;
		
		if(organizador == null)
			return false;
		
		if(preco.compareTo(BigDecimal.ZERO) <= 0)
			return false;
		
		return true;
	}
}
