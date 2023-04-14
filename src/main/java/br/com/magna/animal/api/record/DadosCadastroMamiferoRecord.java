package br.com.magna.animal.api.record;

import br.com.magna.animal.api.model.TipoSangue;
import br.com.magna.animal.api.model.VertebradoInvertebrado;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosCadastroMamiferoRecord(
		@NotBlank
		@Pattern(regexp = "[a-zA-Z ]+", message = "O campo deve conter apenas letras")
		String nome,
		
		@NotBlank
		@Pattern(regexp = "[a-zA-Z ]+", message = "O campo deve conter apenas letras")
		String cor,
		
		@NotNull
		@Positive
		Double peso, 
		
		@NotNull
		VertebradoInvertebrado vertebradoInvertebrado, 
		
		@NotNull
		TipoSangue tipoSangue,
		
		@NotNull
		Boolean pelos, 
		
		@NotNull
		@AssertTrue
		Boolean glandulasMamarias, 
		
		@NotNull
		@PositiveOrZero
		@Max(value = 4)
		Integer patas,
		
		@NotNull
		String tipoMamifero,
		
		@NotNull
		String alimentacao) {

}
