package br.edu.infnet.sgi.services;

import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.models.Cliente;

@Service
public class ClienteService {

	public Cliente criarCliente(Cliente novoCliente)
	{
		// Chamar método do repositório para salvar cliente
		return novoCliente;
	}
	
	public Cliente buscarCliente(long id)
	{
		// Chamar método do repositório para buscar cliente
		
		return new Cliente();
	}
	
	public Cliente atualizarCliente(Cliente clienteAtualizado)
	{		
		// Chamar método do repositório para salvar alterações no cliente
		return clienteAtualizado;
	}
	
	public void deletarCliente(long id)
	{
		// Chamar método do repositório para deletar cliente
	}
}
