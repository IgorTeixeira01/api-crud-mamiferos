package br.com.magna.animal.api.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.animal.api.model.domain.Alimentacao;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long>{
	
	@Query("""
			SELECT a FROM Alimentacao a
			WHERE
			(a.nome = :alimentacao)
			""")
	Alimentacao verificandoAlimentacao(String alimentacao);

}
