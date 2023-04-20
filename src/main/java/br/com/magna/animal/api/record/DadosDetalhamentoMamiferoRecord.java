package br.com.magna.animal.api.record;

import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.model.TipoSangue;
import br.com.magna.animal.api.model.VertebradoInvertebrado;

public record DadosDetalhamentoMamiferoRecord(Long id, 
		String nome, 
		String cor, 
		Double peso,
		VertebradoInvertebrado vertebradoInvertebrado, 
		TipoSangue tipoSangue, 
		Boolean pelos, 
		Boolean glandulasMamarias,
		Integer patas, 
		String tipoMamifero, 
		String alimentacao,
		String ambiente) {

	public DadosDetalhamentoMamiferoRecord(Mamifero mamifero) {
		this(mamifero.getId(), 
				mamifero.getNome(), 
				mamifero.getCor(), 
				mamifero.getPeso(),
				mamifero.getVertebradoInvertebrado(), 
				mamifero.getTipoSangue(), 
				mamifero.getPelos(),
				mamifero.getGlandulasMamarias(), 
				mamifero.getPatas(), 
				mamifero.getTipoMamifero(),
				mamifero.getAlimentacao(),
				mamifero.getAmbiente());
	}


}
