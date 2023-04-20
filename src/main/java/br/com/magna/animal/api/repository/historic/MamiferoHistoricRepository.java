package br.com.magna.animal.api.repository.historic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.animal.api.model.historic.MamiferoHistoric;

@Repository
public interface MamiferoHistoricRepository extends JpaRepository<MamiferoHistoric, Long>{

}
