package br.com.magna.animal.api.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.animal.api.model.domain.TipoMamifero;

public interface TipoMamiferoRepository extends JpaRepository<TipoMamifero, Long>{
	
	@Query("""
			SELECT t FROM TipoMamifero t
			WHERE
			(t.nome = :tipoMamifero)
			""")
	TipoMamifero verificandoTipoMamifero(String tipoMamifero);

}
