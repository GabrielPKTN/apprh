package br.com.apprh.model;

import java.io.Serializable; //Transforma objetos em binario para manipular

import java.util.List; // Listas

import jakarta.persistence.Entity; //Definir entidades

import jakarta.persistence.GeneratedValue; //ID automatico
import jakarta.persistence.GenerationType;

/*Efeito cascata, se eu apago uma vaga, tudo aquilo que for 
 *relacionado vai ser apagado, ex: Candidatos para aquela vaga*/
import jakarta.persistence.CascadeType; 

import jakarta.persistence.Id; // Define o campo como ID

import jakarta.persistence.OneToMany; // Relação um pra muitos

import jakarta.validation.constraints.NotEmpty; // Validação de campo

//Classe que cria a entidade vaga.

@Entity
public class Vaga implements Serializable {
	
	//MECANISMO DE SEGURANÇA
	
	// Faz o controle de versionamento de um objeto
	// verifica se a versão do objeto é compativel com 
	// a versão da classe que serializou.
	private static final long serialVersionUID = 1L; 
	
	
	/*
	 * Essa classe é reponsavel por dizer ao banco de
	 * dados como as tabelas serão criadas, o Id diz
	 * ao banco de dados que quando um objeto for criado
	 * o código dele será o Id, GeneratedValue faz a 
	 * geração desse Id automaticamente.
	 * 
	 * OBS: strategy == Qual o padrão de geração do Id? AUTO
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String descricao;
	
	@NotEmpty
	private String data;
	
	@NotEmpty
	private String salario;
	
	/*
	 * Uma vaga tem multiplos candidatos. Por isso usamos o OneToMany
	 * CascadeType.REMOVE alem de deletar a vaga, deleta os candidatos
	 * para aquela vaga.
	 * 
	 * Dessa maneira evita deixar candidatos "Orfãos", um candidato
	 * relacionado a nada.
	 * 
	 */
	
	@OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE) 
	private List<Candidato> candidatos;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
}