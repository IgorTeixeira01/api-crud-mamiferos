package br.com.magna.animal.api.record;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosAtualizacaoMamiferoRecord(
		@NotNull
		Long id, 
		@Pattern(regexp = "[a-zA-Z ]+", message = "O campo deve conter apenas letras")
		String nome, 
		@Pattern(regexp = "[a-zA-Z ]+", message = "O campo deve conter apenas letras")
		String cor, 
		@Positive
		Double peso,
		Boolean pelos,
		@PositiveOrZero
		@Max(value = 4)
		Integer patas) {

}
