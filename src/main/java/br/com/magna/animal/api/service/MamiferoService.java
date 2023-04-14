package br.com.magna.animal.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.model.domain.Alimentacao;
import br.com.magna.animal.api.model.domain.TipoMamifero;
import br.com.magna.animal.api.record.DadosAtualizacaoMamiferoRecord;
import br.com.magna.animal.api.record.DadosCadastroMamiferoRecord;
import br.com.magna.animal.api.record.DadosListagemMamiferoRecord;
import br.com.magna.animal.api.repository.MamiferoRepository;
import br.com.magna.animal.api.repository.domain.AlimentacaoRepository;
import br.com.magna.animal.api.repository.domain.TipoMamiferoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MamiferoService {

	@Autowired
	private MamiferoRepository repository;
	
	@Autowired
	private AlimentacaoRepository alimentacaoRepository;
	
	@Autowired
	private TipoMamiferoRepository tipoMamiferoRepository;

	public Mamifero cadastrarMamifero(DadosCadastroMamiferoRecord dados) {
		Mamifero mamifero = new Mamifero();
		mamifero.setNome(dados.nome());
		mamifero.setCor(dados.cor());
		mamifero.setPeso(dados.peso());
		mamifero.setVertebradoInvertebrado(dados.vertebradoInvertebrado());
		mamifero.setTipoSangue(dados.tipoSangue());
		mamifero.setPelos(dados.pelos());
		mamifero.setGlandulasMamarias(dados.glandulasMamarias());
		mamifero.setPatas(dados.patas());
		TipoMamifero tipoMamifero = tipoMamiferoRepository.verificandoTipoMamifero(dados.tipoMamifero());
		mamifero.setTipoMamifero(tipoMamifero.getNomeTipo());
		Alimentacao alimentacao = alimentacaoRepository.verificandoAlimentacao(dados.alimentacao());
		mamifero.setAlimentacao(alimentacao.getNomeAlimentacao());
		return repository.save(mamifero);
	}

	public Page<DadosListagemMamiferoRecord> listarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemMamiferoRecord::new); 
	}

	public DadosListagemMamiferoRecord listarPorId(Long id) {
		var mamifero = repository.getReferenceById(id);
		return new DadosListagemMamiferoRecord(mamifero);
	}

	public DadosListagemMamiferoRecord atualizarMamifero(DadosAtualizacaoMamiferoRecord dados) {
		Mamifero mamifero = repository.getReferenceById(dados.id());
		mamifero.atualizarInformacoes(dados);
		return new DadosListagemMamiferoRecord(mamifero);
	}

	public void excluirMamifero(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException();
		}
	}

}
