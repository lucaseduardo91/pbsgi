package br.edu.infnet.sgi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sgi.models.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {

}
