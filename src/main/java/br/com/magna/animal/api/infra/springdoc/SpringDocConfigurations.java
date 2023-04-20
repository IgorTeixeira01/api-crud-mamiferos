package br.com.magna.animal.api.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearer-key",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
				.info(new Info().title("Magna Zoo").description(
						"Essa API Rest com Spring Boot permite realizar operações CRUD (Create, Read, Update, Delete) de mamíferos. "
						+ "Através dela, é possível criar, recuperar, atualizar e excluir registros de mamíferos armazenados em um banco de dados. "
						+ "\nOs dados que podem ser inseridos na criação de um registro incluem o nome do mamífero, sua cor, peso, se ele é vertebrado ou invertebrado, "
						+ "o tipo de sangue, se possui pelos, a presença de glândulas mamárias, a quantidade de patas, o tipo do mamífero e sua alimentação e ambiente."
						+ "\nA API é construída seguindo os princípios do protocolo HTTP, tornando-se fácil de integrar com outras aplicações e sistemas. "
						+ "Ela oferece respostas em formato JSON, que é amplamente utilizado no desenvolvimento de aplicações web. Além disso, a API possui um "
						+ "conjunto de endpoints bem definidos para cada operação CRUD.")
						.contact(new Contact().name("Magna Zoo - Igor").email("irocha@magnasistemas.com").url("https://github.com/IgorTeixeira01"))
						.license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
						.version("1.0.1"));
	}

}