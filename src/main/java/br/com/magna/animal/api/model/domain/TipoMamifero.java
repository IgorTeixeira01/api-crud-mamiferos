package br.com.magna.animal.api.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_TIPO_MAMIFERO")
@Entity
public class TipoMamifero{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Long id;
	@Column(name = "VAR_NOME")
	private String nome;
	@Column(name = "BOOL_MAMILOS")
	private Boolean mamilos;
	@Column(name = "BOOL_MARSUPIO")
	private Boolean marsupio;
	@Column(name = "BOOL_PLACENTA")
	private Boolean placenta;
	
	
	public Long getId() {
		return id;
	}

	public String getNome() {
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


}
