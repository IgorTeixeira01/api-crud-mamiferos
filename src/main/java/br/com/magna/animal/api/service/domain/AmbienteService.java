package br.com.magna.animal.api.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.animal.api.record.domain.DadosDetalhamentoAmbienteRecord;
import br.com.magna.animal.api.repository.domain.AmbienteRepository;

@Service
public class AmbienteService {
	
	@Autowired
	private AmbienteRepository repository;
	
	public Page<DadosDetalhamentoAmbienteRecord> listarTodos(Pageable paginacao){
		return repository.findAll(paginacao).map(DadosDetalhamentoAmbienteRecord::new);
	}

}
