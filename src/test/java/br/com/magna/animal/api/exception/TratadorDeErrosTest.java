package br.com.magna.animal.api.exception;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.animal.api.dto.MamiferoCadastroDTO;
import br.com.magna.animal.api.model.Mamifero;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TratadorDeErrosTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCadastrar() {
		MamiferoCadastroDTO dados = new MamiferoCadastroDTO();
		dados.setNome(null);
		dados.setCor(null);
		dados.setPeso(null);
		dados.setVertebradoInvertebrado(null);
		dados.setTipoSangue(null);
		dados.setPelos(null);
		dados.setGlandulasMamarias(null);
		dados.setPatas(null);
		dados.setTipoMamifero(null);
		dados.setAlimentacao(null);
		ResponseEntity<String> response = restTemplate.postForEntity("/mamiferos/cadastrar", dados, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
	@Test
	void testExcluir() {
		restTemplate.delete("/mamiferos/excluir/99");
		ResponseEntity<Mamifero> response = restTemplate.getForEntity("/excluir/99", Mamifero.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	

}
