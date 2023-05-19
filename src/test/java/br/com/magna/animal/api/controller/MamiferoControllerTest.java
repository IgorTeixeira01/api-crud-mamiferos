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

import br.com.magna.animal.api.dto.MamiferoAtualizacaoDTO;
import br.com.magna.animal.api.dto.MamiferoCadastroDTO;
import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.model.TipoSangue;
import br.com.magna.animal.api.model.VertebradoInvertebrado;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class MamiferoControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCadastrarTerrestre() {
		MamiferoCadastroDTO dados = new MamiferoCadastroDTO();
		dados.setNome("Cachorro");
		dados.setCor("Preto");
		dados.setPeso(40.0);
		dados.setVertebradoInvertebrado(VertebradoInvertebrado.VERTEBRADO);
		dados.setTipoSangue(TipoSangue.QUENTE);
		dados.setPelos(true);
		dados.setGlandulasMamarias(true);
		dados.setPatas(4);
		dados.setTipoMamifero("Placentario");
		dados.setAlimentacao("Carnivoro");
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testCadastrarAereo() {
		MamiferoCadastroDTO dados = new MamiferoCadastroDTO();
		dados.setNome("Morcego");
		dados.setCor("Preto");
		dados.setPeso(0.100);
		dados.setVertebradoInvertebrado(VertebradoInvertebrado.VERTEBRADO);
		dados.setTipoSangue(TipoSangue.QUENTE);
		dados.setPelos(true);
		dados.setGlandulasMamarias(true);
		dados.setPatas(4);
		dados.setTipoMamifero("Placentario");
		dados.setAlimentacao("Carnivoro");
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testCadastrarAquatico() {
		MamiferoCadastroDTO dados = new MamiferoCadastroDTO();
		dados.setNome("Baleia");
		dados.setCor("Azul");
		dados.setPeso(1000.0);
		dados.setVertebradoInvertebrado(VertebradoInvertebrado.VERTEBRADO);
		dados.setTipoSangue(TipoSangue.QUENTE);
		dados.setPelos(false);
		dados.setGlandulasMamarias(true);
		dados.setPatas(0);
		dados.setTipoMamifero("Placentario");
		dados.setAlimentacao("Carnivoro");
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
		MamiferoAtualizacaoDTO dados = new MamiferoAtualizacaoDTO();
		dados.setId(1L);
		dados.setNome("Cachorro");
		dados.setCor("Preto");
		dados.setPeso(22.5);
		dados.setPelos(true);
		dados.setPatas(4);
		ResponseEntity<Mamifero> response = restTemplate.exchange("/mamiferos/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), Mamifero.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Cachorro", response.getBody().getNome()); 
	}
	
	@Test
	void testAtualizarAereo() {
		MamiferoAtualizacaoDTO dados = new MamiferoAtualizacaoDTO();
		dados.setId(2L);
		dados.setNome("Morcego");
		dados.setCor("Preto");
		dados.setPeso(0.100);
		dados.setPelos(true);
		dados.setPatas(4);
		ResponseEntity<Mamifero> response = restTemplate.exchange("/mamiferos/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), Mamifero.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Morcego", response.getBody().getNome()); 
	}
	
	@Test
	void testAtualizarAquatico() {
		MamiferoAtualizacaoDTO dados = new MamiferoAtualizacaoDTO();
		dados.setId(2L);
		dados.setNome("Baleia");
		dados.setCor("Azul");
		dados.setPeso(1000.0);
		dados.setPelos(false);
		dados.setPatas(0);
		ResponseEntity<Mamifero> response = restTemplate.exchange("/mamiferos/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), Mamifero.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Baleia", response.getBody().getNome()); 
	}
	
	@Test
	void testExcluir() {
		restTemplate.delete("/mamiferos/excluir/5");
		ResponseEntity<Mamifero> response = restTemplate.getForEntity("/excluir/5", Mamifero.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
}
