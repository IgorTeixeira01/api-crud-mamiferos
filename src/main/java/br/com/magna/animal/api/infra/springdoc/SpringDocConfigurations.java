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
						"API Rest da aplicação Magna Zoo. No momento, contém apenas a funcionalidade de CRUD de animais mamíferos. " + 
				"Posteriormente, pretendemos adicionar essa funcionalidade para outros tipos de animais, como peixes, aves, répteis...")
						.contact(new Contact().name("Magna Zoo - Igor").email("irocha@magnasistemas.com").url("https://github.com/IgorTeixeira01"))
						.license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
						.version("1.0.1"));
	}

}