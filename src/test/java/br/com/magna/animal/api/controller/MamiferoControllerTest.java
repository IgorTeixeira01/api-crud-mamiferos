package br.com.magna.animal.api.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.model.TipoSangue;
import br.com.magna.animal.api.model.VertebradoInvertebrado;
import br.com.magna.animal.api.record.DadosAtualizacaoMamiferoRecord;
import br.com.magna.animal.api.record.DadosCadastroMamiferoRecord;
import br.com.magna.animal.api.record.DadosListagemMamiferoRecord;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class MamiferoControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCadastrar() {
		DadosCadastroMamiferoRecord dados = new DadosCadastroMamiferoRecord("Cachorro", "Preto", 20.0, VertebradoInvertebrado.VERTEBRADO, TipoSangue.QUENTE, true, true, 4, "Placentario", "Carnivoro");
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testListar() {
		ResponseEntity<String> response = restTemplate.exchange("/mamiferos/listagem?page=0&size=10", 
		HttpMethod.GET,null, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	}
	
	@Test
	void testListarPorId() {
		ResponseEntity<String> response = restTemplate.exchange("/mamiferos/listagem/1", 
				HttpMethod.GET,null, String.class);
				Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
				Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	}
	
	@Test
	void testAtualizar() {
		DadosAtualizacaoMamiferoRecord dados = new DadosAtualizacaoMamiferoRecord(1L, "Cachorrao", "Preto", 22.5, true, 4);
		ResponseEntity<DadosListagemMamiferoRecord> response = restTemplate.exchange("/mamiferos/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), DadosListagemMamiferoRecord.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("Cachorrao", response.getBody().nome()); 
	}
	
	@Test
	void testExcluir() {
		restTemplate.delete("/mamiferos/excluir/13");
		ResponseEntity<Mamifero> response = restTemplate.getForEntity("/excluir/13", Mamifero.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
}
