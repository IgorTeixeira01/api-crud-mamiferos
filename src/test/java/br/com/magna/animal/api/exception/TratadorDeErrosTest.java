package br.com.magna.animal.api.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.record.DadosCadastroMamiferoRecord;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TratadorDeErrosTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCadastrar() {
		DadosCadastroMamiferoRecord dados = new DadosCadastroMamiferoRecord(null, null, null, null, null, null, null, null, null, null);
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
	@Test
	void testExcluir() {
		restTemplate.delete("/mamiferos/excluir/6");
		ResponseEntity<Mamifero> response = restTemplate.getForEntity("/excluir/6", Mamifero.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	

}
