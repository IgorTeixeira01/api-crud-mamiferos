package br.com.magna.animal.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class MamiferoAtualizacaoDTO {
	
	@NotNull
	Long id;
	@Pattern(regexp="^[A-Z][a-zA-Z]*(?:[- ][A-Z][a-zA-Z]*)*$", message = "As palavras devem iniciar com letra maiuscula e conter apenas letras, espaço ou hífen")
	String nome;
	@Pattern(regexp = "^[A-Z][a-zA-Z\\- ]*$", message = "O campo deve iniciar com letra maiuscula e conter apenas letras, espaço ou hífen")
	String cor;
	@Positive
	Double peso;
	Boolean pelos;
	@PositiveOrZero
	@Max(value = 4)
	Integer patas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Boolean getPelos() {
		return pelos;
	}
	public void setPelos(Boolean pelos) {
		this.pelos = pelos;
	}
	public Integer getPatas() {
		return patas;
	}
	public void setPatas(Integer patas) {
		this.patas = patas;
	}
	
	

}
