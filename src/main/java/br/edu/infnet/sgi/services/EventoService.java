package br.edu.infnet.sgi.services;

import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.models.Endereco;
import br.edu.infnet.sgi.models.Evento;
import br.edu.infnet.sgi.models.Organizador;

@Service
public class EventoService {

	public Evento criarEvento(Evento novoEvento)
	{		
		validarDadosEvento(novoEvento);
		// Chamar método do repositório para salvar evento
		return novoEvento;
	}
	
	public Evento buscarEvento(long id)
	{
		// Chamar método do repositório para buscar evento
		
		return new Evento();
	}
	
	public Evento consultarHistorico(long id)
	{
		// Chamar método do repositório para buscar eventos passados com participação do usuário
		
		return new Evento();
	}
	
	public Evento atualizarEvento(Evento eventoAtualizado)
	{		
		// Chamar método do repositório para salvar alterações no evento
		return eventoAtualizado;
	}
	
	public void deletarEvento(long id)
	{
		// Chamar método do repositório para deletar evento
	}
	
	private boolean validarDadosEvento(Evento evento) {
		String nome = evento.getNome();
		String tipoEvento = evento.getTipoEvento();
		String descricao = evento.getDescricao();
		int lotacao = evento.getLotacao();
		Endereco endereco = evento.getEndereco();
		Organizador organizador = evento.getOrganizador();
		
		if(nome == null || nome.length() < 2 || nome.length() > 50)
			return false;
		
		if(tipoEvento == null || tipoEvento.length() < 2 || tipoEvento.length() > 20)
			return false;
		
		if(descricao == null || descricao.length() < 2 || descricao.length() > 50)
			return false;
		
		if(lotacao <= 0)
			return false;
		
		if(!validarEndereco(endereco))
			return false;
		
		if(organizador == null)
			return false;
		
		return true;
	}
	
	private boolean validarEndereco(Endereco endereco)
	{
		if(endereco == null)
			return false;
		
		if(endereco.getEnderecoCompleto() == null || endereco.getCidade() == null || endereco.getBairro() == null)
			return false;
		
		return true;
	}
}
