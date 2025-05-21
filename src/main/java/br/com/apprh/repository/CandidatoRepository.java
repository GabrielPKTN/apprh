package br.com.apprh.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.apprh.model.Candidato;
import br.com.apprh.model.Vaga;

public interface CandidatoRepository extends CrudRepository<Candidato, String>{
	
	Iterable<Candidato>findByVaga(Vaga vaga);
	
	Candidato findByRg(String rg);
	
	Candidato findById(long id);
	
	List<Candidato>findByNomeCandidato(String nomeCandidato);
}
