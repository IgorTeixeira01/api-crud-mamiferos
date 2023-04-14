package br.com.magna.animal.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.animal.api.model.Mamifero;

@Repository
public interface MamiferoRepository extends JpaRepository<Mamifero, Long>{

}
