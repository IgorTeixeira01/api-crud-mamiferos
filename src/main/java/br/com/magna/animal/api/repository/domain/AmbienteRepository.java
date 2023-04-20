package br.com.magna.animal.api.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.animal.api.model.domain.Ambiente;

public interface AmbienteRepository extends JpaRepository<Ambiente, Long>{
	
	@Query("""
			SELECT a FROM Ambiente a
			WHERE
			(a.nome = :ambiente)
			""")
	Ambiente verificandoAmbiente(String ambiente);

}
