package br.com.magna.animal.api.model;

import br.com.magna.animal.api.record.DadosAtualizacaoMamiferoRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_MAMIFERO")
@Entity

public class Mamifero extends AbstractEntity<Mamifero, Long>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Long id;
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
	@Column(name = "VAR_AMBIENTE")
	private String ambiente;

	@Override
	public Long getId() {
		return id;
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
	
	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	
	public void atualizarInformacoes(DadosAtualizacaoMamiferoRecord dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if(dados.cor() != null) {
			this.cor = dados.cor();
		}
		
		if(dados.peso() != null) {
			this.peso = dados.peso();
		}
		
		if(dados.pelos() != null) {
			this.pelos = dados.pelos();
		}
		
		if(dados.patas() != null) {
			this.patas = dados.patas();
		}
		
	}



}
