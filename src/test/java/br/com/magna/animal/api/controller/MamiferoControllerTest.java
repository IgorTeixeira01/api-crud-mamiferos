package br.com.magna.animal.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import br.com.magna.animal.api.record.DadosDetalhamentoMamiferoRecord;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class MamiferoControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCadastrarTerrestre() {
		DadosCadastroMamiferoRecord dados = new DadosCadastroMamiferoRecord("Cachorro", "Preto", 20.0, VertebradoInvertebrado.VERTEBRADO, TipoSangue.QUENTE, true, true, 4, "Placentario", "Carnivoro");
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testCadastrarAereo() {
		DadosCadastroMamiferoRecord dados = new DadosCadastroMamiferoRecord("Morcego", "Preto", 3.0, VertebradoInvertebrado.VERTEBRADO, TipoSangue.QUENTE, true, true, 0, "Placentario", "Carnivoro");
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testCadastrarAquatico() {
		DadosCadastroMamiferoRecord dados = new DadosCadastroMamiferoRecord("Baleia", "Azul", 1000.0, VertebradoInvertebrado.VERTEBRADO, TipoSangue.QUENTE, false, true, 0, "Placentario", "Carnivoro");
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testListar() {
		ResponseEntity<String> response = restTemplate.exchange("/mamiferos/listagem?page=0&size=10", 
		HttpMethod.GET,null, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	}
	
	@Test
	void testListarPorId() {
		ResponseEntity<String> response = restTemplate.exchange("/mamiferos/detalhar/12", 
				HttpMethod.GET,null, String.class);
				assertEquals(HttpStatus.OK, response.getStatusCode());
				assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	}
	
	@Test
	void testAtualizarTerrestre() {
		DadosAtualizacaoMamiferoRecord dados = new DadosAtualizacaoMamiferoRecord(1L, "Cachorro", "Preto", 22.5, true, 4);
		ResponseEntity<DadosDetalhamentoMamiferoRecord> response = restTemplate.exchange("/mamiferos/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), DadosDetalhamentoMamiferoRecord.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Cachorro", response.getBody().nome()); 
	}
	
	@Test
	void testAtualizarAereo() {
		DadosAtualizacaoMamiferoRecord dados = new DadosAtualizacaoMamiferoRecord(2L, "Morcego", "Preto", 5.0, true, 2);
		ResponseEntity<DadosDetalhamentoMamiferoRecord> response = restTemplate.exchange("/mamiferos/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), DadosDetalhamentoMamiferoRecord.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Morcego", response.getBody().nome()); 
	}
	
	@Test
	void testAtualizarAquatico() {
		DadosAtualizacaoMamiferoRecord dados = new DadosAtualizacaoMamiferoRecord(3L, "Baleia", "Azul", 1000.5, false, 0);
		ResponseEntity<DadosDetalhamentoMamiferoRecord> response = restTemplate.exchange("/mamiferos/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), DadosDetalhamentoMamiferoRecord.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Baleia", response.getBody().nome()); 
	}
	
	@Test
	void testExcluir() {
		restTemplate.delete("/mamiferos/excluir/5");
		ResponseEntity<Mamifero> response = restTemplate.getForEntity("/excluir/5", Mamifero.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
}
