package br.com.magna.animal.api.dto;

import br.com.magna.animal.api.model.TipoSangue;
import br.com.magna.animal.api.model.VertebradoInvertebrado;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class MamiferoCadastroDTO {
	
	@NotBlank
	@Pattern(regexp="^[A-Z][a-zA-Z]*(?:[- ][A-Z][a-zA-Z]*)*$", message = "As palavras devem iniciar com letra maiuscula e conter apenas letras, espaço ou hífen")
	String nome;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z][a-zA-Z\\- ]*$", message = "O campo deve iniciar com letra maiuscula e conter apenas letras, espaço ou hífen")
	String cor;
	
	@NotNull
	@Positive
	Double peso;
	
	@NotNull
	VertebradoInvertebrado vertebradoInvertebrado; 
	
	@NotNull
	TipoSangue tipoSangue;
	
	@NotNull
	Boolean pelos;
	
	@NotNull
	@AssertTrue
	Boolean glandulasMamarias;
	
	@NotNull
	@PositiveOrZero
	@Max(value = 4)
	Integer patas;
	
	@NotBlank
	String tipoMamifero;
	
	@NotBlank
	String alimentacao;

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

	public VertebradoInvertebrado getVertebradoInvertebrado() {
		return vertebradoInvertebrado;
	}

	public void setVertebradoInvertebrado(VertebradoInvertebrado vertebradoInvertebrado) {
		this.vertebradoInvertebrado = vertebradoInvertebrado;
	}

	public TipoSangue getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(TipoSangue tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public Boolean getPelos() {
		return pelos;
	}

	public void setPelos(Boolean pelos) {
		this.pelos = pelos;
	}

	public Boolean getGlandulasMamarias() {
		return glandulasMamarias;
	}

	public void setGlandulasMamarias(Boolean glandulasMamarias) {
		this.glandulasMamarias = glandulasMamarias;
	}

	public Integer getPatas() {
		return patas;
	}

	public void setPatas(Integer patas) {
		this.patas = patas;
	}

	public String getTipoMamifero() {
		return tipoMamifero;
	}

	public void setTipoMamifero(String tipoMamifero) {
		this.tipoMamifero = tipoMamifero;
	}

	public String getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}
	
	

}
