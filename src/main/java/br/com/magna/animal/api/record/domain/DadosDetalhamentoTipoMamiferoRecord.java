package br.com.magna.animal.api.record.domain;

import br.com.magna.animal.api.model.domain.TipoMamifero;

public record DadosDetalhamentoTipoMamiferoRecord(Long idTipo, String nomeTipo, Boolean mamilos, Boolean marsupio, Boolean placenta) {

	public DadosDetalhamentoTipoMamiferoRecord(TipoMamifero tipoMamifero) {
		this(tipoMamifero.getId(), tipoMamifero.getNome(), tipoMamifero.getMamilos(), 
				tipoMamifero.getMarsupio(), tipoMamifero.getPlacenta());
	}
}
