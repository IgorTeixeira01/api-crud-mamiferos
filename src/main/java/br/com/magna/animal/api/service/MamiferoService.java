package br.com.magna.animal.api.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.model.domain.Alimentacao;
import br.com.magna.animal.api.model.domain.TipoMamifero;
import br.com.magna.animal.api.model.historic.MamiferoHistoric;
import br.com.magna.animal.api.record.DadosAtualizacaoMamiferoRecord;
import br.com.magna.animal.api.record.DadosCadastroMamiferoRecord;
import br.com.magna.animal.api.record.DadosListagemMamiferoRecord;
import br.com.magna.animal.api.repository.MamiferoRepository;
import br.com.magna.animal.api.repository.domain.AlimentacaoRepository;
import br.com.magna.animal.api.repository.domain.TipoMamiferoRepository;
import br.com.magna.animal.api.repository.historic.MamiferoRepositoryHistoric;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MamiferoService {

	@Autowired
	private MamiferoRepository repository;
	
	@Autowired
	private AlimentacaoRepository alimentacaoRepository;
	
	@Autowired
	private TipoMamiferoRepository tipoMamiferoRepository;
	
	@Autowired
	private MamiferoRepositoryHistoric mamiferoHistoricRepository;
	
	private String dbUser = "Admin";
	
	private String dbUser2 = "Admin2";
	
	public Mamifero cadastrarMamifero(DadosCadastroMamiferoRecord dados) {
		Mamifero mamifero = new Mamifero();
		mamifero.setUserDatabaseCreate(dbUser);
		mamifero.setUserDatabaseUpdate(dbUser);
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

		mamifero.setTimestampFirstCreated(ZonedDateTime.now());
		mamifero.setTimestampLastUpdate(ZonedDateTime.now());
		mamifero.setTimestampTimeZone(ZonedDateTime.now().getZone());
		
		repository.save(mamifero);
		
		MamiferoHistoric mamiferoHistoric = cadastrarMamiferoHistoric(mamifero);
		mamiferoHistoricRepository.save(mamiferoHistoric);
		
		return mamifero;
	}

	public Page<DadosListagemMamiferoRecord> listarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemMamiferoRecord::new); 
	}

	public DadosListagemMamiferoRecord listarPorId(Long id) {
		var mamifero = repository.getReferenceById(id);
		return new DadosListagemMamiferoRecord(mamifero);
	}

	public Mamifero atualizarMamifero(DadosAtualizacaoMamiferoRecord dados) {
		Mamifero mamifero = repository.getReferenceById(dados.id());
		MamiferoHistoric mamiferoHistoric = cadastrarMamiferoHistoric(mamifero);
		mamiferoHistoricRepository.save(mamiferoHistoric);
		mamifero.atualizarInformacoes(dados);
		mamifero.setUserDatabaseCreate(dbUser);
		mamifero.setUserDatabaseUpdate(dbUser2);
		mamifero.setTimestampLastUpdate(ZonedDateTime.now());
		repository.save(mamifero);
		return mamifero;
	}

	public void excluirMamifero(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException();
		}
	}
	
	public MamiferoHistoric cadastrarMamiferoHistoric (Mamifero mamifero) {
		MamiferoHistoric mamiferoHistoric = new MamiferoHistoric();
		
		mamiferoHistoric.setIdMamifero(mamifero.getId());
		mamiferoHistoric.setNome(mamifero.getNome());
		mamiferoHistoric.setCor(mamifero.getCor());
		mamiferoHistoric.setPeso(mamifero.getPeso());
		mamiferoHistoric.setVertebradoInvertebrado(mamifero.getVertebradoInvertebrado());
		mamiferoHistoric.setTipoSangue(mamifero.getTipoSangue());
		mamiferoHistoric.setPelos(mamifero.getPelos());
		mamiferoHistoric.setGlandulasMamarias(mamifero.getGlandulasMamarias());
		mamiferoHistoric.setPatas(mamifero.getPatas());
		TipoMamifero tipoMamifero = tipoMamiferoRepository.verificandoTipoMamifero(mamifero.getTipoMamifero());
		mamiferoHistoric.setTipoMamifero(tipoMamifero.getNomeTipo());
		Alimentacao alimentacao = alimentacaoRepository.verificandoAlimentacao(mamifero.getAlimentacao());
		mamiferoHistoric.setAlimentacao(alimentacao.getNomeAlimentacao());
		
		mamiferoHistoric.setUserDatabaseCreate(mamifero.getUserDatabaseCreate());
		mamiferoHistoric.setUserDatabaseUpdate(dbUser2);
		mamiferoHistoric.setTimestampFirstCreated(mamifero.getTimestampFirstCreated());
		mamiferoHistoric.setTimestampLastUpdate(ZonedDateTime.now());
		mamiferoHistoric.setTimestampTimeZone(ZonedDateTime.now().getZone());
		
		return mamiferoHistoric;
	}

}
