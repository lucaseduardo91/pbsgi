package br.edu.infnet.sgi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sgi.models.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {
	List<Evento> findByTipoEvento(String tipoEvento);
	List<Evento> findByNome(String nome);
}
