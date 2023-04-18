package br.com.magna.animal.api.record.domain;

import br.com.magna.animal.api.model.domain.TipoMamifero;

public record DadosListagemTipoMamiferoRecord(Long idTipo, String nomeTipo, Boolean mamilos, Boolean marsupio, Boolean placenta) {

	public DadosListagemTipoMamiferoRecord(TipoMamifero tipoMamifero) {
		this(tipoMamifero.getId(), tipoMamifero.getNomeTipo(), tipoMamifero.getMamilos(), 
				tipoMamifero.getMarsupio(), tipoMamifero.getPlacenta());
	}
}
