package br.com.magna.animal.api.record.domain;

import br.com.magna.animal.api.model.domain.Ambiente;

public record DadosDetalhamentoAmbienteRecord(Long idAmbiente, String nomeAmbiente) {

	public DadosDetalhamentoAmbienteRecord(Ambiente ambiente) {
		this(ambiente.getId(), ambiente.getNome());
	}
}
