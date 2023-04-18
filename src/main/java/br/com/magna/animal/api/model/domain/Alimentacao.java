package br.com.magna.animal.api.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_ALIMENTACAO")
@Entity
public class Alimentacao{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "fonte_animal")
	private Boolean fonteAnimal;
	@Column(name = "fonte_vegetal")
	private Boolean fonteVegetal;
	

	public Long getId() {
		return id;
	}
	
	public String getNomeAlimentacao() {
		return nome;
	}
	public Boolean getFonteVegetal() {
		return fonteVegetal;
	}
	public Boolean getFonteAnimal() {
		return fonteAnimal;
	}
}
