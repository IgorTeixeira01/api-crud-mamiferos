package br.com.magna.animal.api.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.animal.api.model.domain.TipoMamifero;
import br.com.magna.animal.api.repository.domain.TipoMamiferoRepository;

@Service
public class TipoMamiferoService {
	
	@Autowired
	private TipoMamiferoRepository repository;
	
	public Page<TipoMamifero> listarTodos(Pageable paginacao){
		return repository.findAll(paginacao);
	}

}
