package br.com.magna.animal.api.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.animal.api.model.domain.Alimentacao;
import br.com.magna.animal.api.repository.domain.AlimentacaoRepository;

@Service
public class AlimentacaoService {
	
	@Autowired
	private AlimentacaoRepository repository;
	
	public Page<Alimentacao> listarTodos(Pageable paginacao){
		return repository.findAll(paginacao);
	}

}
