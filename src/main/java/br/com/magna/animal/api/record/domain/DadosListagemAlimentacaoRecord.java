package br.com.magna.animal.api.record.domain;

import br.com.magna.animal.api.model.domain.Alimentacao;

public record DadosListagemAlimentacaoRecord(Long idAlimentacao, String nomeAlimentacao, Boolean fonteAnimal, Boolean fonteVegetal) {

	public DadosListagemAlimentacaoRecord(Alimentacao alimentacao) {
		this(alimentacao.getId(), alimentacao.getNomeAlimentacao(), alimentacao.getFonteAnimal(), 
				alimentacao.getFonteVegetal());
	}
}
