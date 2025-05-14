package br.com.apprh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.apprh.model.Vaga;

public interface VagaRepository extends CrudRepository<Vaga, String> {

	//Pesquisa a vaga pelo código.
	Vaga findByCodigo(long codigo);
	
	//Pesquisa a vaga pelo nome.
	List<Vaga> findByNome(String nome);
	
}
