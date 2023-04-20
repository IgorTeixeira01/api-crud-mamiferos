package br.com.magna.animal.api.model.historic;

import br.com.magna.animal.api.model.AbstractEntity;
import br.com.magna.animal.api.model.TipoSangue;
import br.com.magna.animal.api.model.VertebradoInvertebrado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_MAMIFERO_HISTORIC")
@Entity

public class MamiferoHistoric extends AbstractEntity<MamiferoHistoric, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Long id;
	@Column(name = "ID_MAMIFERO")
	private Long idMamifero;
	@Column(name = "VAR_NOME")
	private String nome;
	@Column(name = "VAR_COR")
	private String cor;
	@Column(name = "DOUBLE_PESO")
	private Double peso;
	@Column(name = "VAR_VERTEBRADO_INVERTEBRADO")
	@Enumerated(EnumType.STRING)
	private VertebradoInvertebrado vertebradoInvertebrado;
	@Column(name = "VAR_TIPO_SANGUE")
	@Enumerated(EnumType.STRING)
	private TipoSangue tipoSangue;
	@Column(name = "BOOL_PELOS")
	private Boolean pelos;
	@Column(name = "BOOL_GLANDULAS_MAMARIAS")
	private Boolean glandulasMamarias;
	@Column(name = "INT_PATAS")
	private Integer patas;
	@Column(name = "VAR_TIPO_MAMIFERO")
	private String tipoMamifero;
	@Column(name = "VAR_ALIMENTACAO")
	private String alimentacao;

	@Override
	public Long getId() {
		return id;
	}

	public void setIdMamifero(Long idMamifero) {
		this.idMamifero = idMamifero;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public void setVertebradoInvertebrado(VertebradoInvertebrado vertebradoInvertebrado) {
		this.vertebradoInvertebrado = vertebradoInvertebrado;
	}


	public void setTipoSangue(TipoSangue tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public void setPelos(Boolean pelos) {
		this.pelos = pelos;
	}

	public void setGlandulasMamarias(Boolean glandulasMamarias) {
		this.glandulasMamarias = glandulasMamarias;
	}

	public void setPatas(Integer patas) {
		this.patas = patas;
	}

	public void setTipoMamifero(String tipoMamifero) {
		this.tipoMamifero = tipoMamifero;
	}

	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}

}
