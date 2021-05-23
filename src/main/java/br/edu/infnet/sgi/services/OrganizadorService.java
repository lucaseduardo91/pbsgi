package br.edu.infnet.sgi.services;

import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.models.Organizador;

@Service
public class OrganizadorService {

	public Organizador criarOrganizador(Organizador novoOrganizador)
	{
		// Chamar método do repositório para salvar organizador
		return novoOrganizador;
	}
	
	public Organizador buscarOrganizador(long id)
	{
		// Chamar método do repositório para buscar organizador
		
		return new Organizador();
	}
	
	public Organizador atualizarOrganizador(Organizador organizadorAtualizado)
	{		
		// Chamar método do repositório para salvar alterações no organizador
		return organizadorAtualizado;
	}
	
	public void deletarOrganizador(long id)
	{
		// Chamar método do repositório para deletar organizador
	}
}
