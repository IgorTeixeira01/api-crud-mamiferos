package br.com.magna.animal.api.record.domain;

import br.com.magna.animal.api.model.domain.Alimentacao;

public record DadosDetalhamentoAlimentacaoRecord(Long idAlimentacao, String nomeAlimentacao, Boolean fonteAnimal, Boolean fonteVegetal) {

	public DadosDetalhamentoAlimentacaoRecord(Alimentacao alimentacao) {
		this(alimentacao.getId(), alimentacao.getNome(), alimentacao.getFonteAnimal(), 
				alimentacao.getFonteVegetal());
	}
}
