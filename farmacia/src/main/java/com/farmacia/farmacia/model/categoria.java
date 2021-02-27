package com.farmacia.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 								//Informando que essa classe é uma ENTIDADE
@Table(name = "categoria")				//Estou informando que a ENTIDADE vai virar uma TABELA

public class categoria {

	@Id	 														//Gerando a coluna ID --> a gente define o ID por meio de código e ele é usado como primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//ID será gerado automáticamente --> deixamos que o Sistema gere (auto_increment) 
	private long id;
	
	@NotNull													// Não pode ficar vazio
	@Size (min = 5, max = 300)									//Qauntidade de Caracteres
	private String recomendacao;

	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cat")
	private List<produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}
	
	public List<produto> getProduto() {
		return produto;
	}

	public void setProduto(List<produto> produto) {
		this.produto = produto;
	}
	
	


}
