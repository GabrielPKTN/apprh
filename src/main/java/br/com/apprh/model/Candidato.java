package br.com.apprh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Relação muitos pra um
import jakarta.persistence.ManyToOne; 
import jakarta.validation.constraints.NotEmpty;

// Classe que cria a entidade candidato.

@Entity
public class Candidato {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true) //Define como unico, só um pode ter esse RG.
	private String rg;
	
	@NotEmpty
	private String nomeCandidato;
	
	@NotEmpty
	private String email;
	
	@ManyToOne
	private Vaga vaga;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
}
