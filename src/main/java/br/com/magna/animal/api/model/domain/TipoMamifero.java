package br.com.magna.animal.api.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_TIPO_MAMIFERO")
@Entity
public class TipoMamifero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "mamilos")
	private Boolean mamilos;
	@Column(name = "marsupio")
	private Boolean marsupio;
	@Column(name = "placenta")
	private Boolean placenta;
	
	
	public String getNomeTipo() {
		return nome;
	}
	public Boolean getMamilos() {
		return mamilos;
	}
	public Boolean getMarsupio() {
		return marsupio;
	}
	public Boolean getPlacenta() {
		return placenta;
	}
	public Long getIdTipo() {
		return id;
	}

}
