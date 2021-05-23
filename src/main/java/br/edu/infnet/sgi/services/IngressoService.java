package br.edu.infnet.sgi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.sgi.models.Evento;
import br.edu.infnet.sgi.models.Ingresso;

@Service
public class IngressoService {

	public boolean verificarDisponibilidade(Ingresso ingresso)
	{
		// chamar método do repositório para verificar disponibilidade
		return true;
	}
	
	public List<Ingresso> obterIngressoDisponiveis(Evento evento)
	{
		// chamar método do repositório para verificar ingresso disponíveis de um evento
		return new ArrayList<Ingresso>();
	}
	
	public void gerarIngressosParaEvento()
	{
		// verificar se vale a pena ter uma entidade complexa como ingresso ou controlar por lotação
	}
}
