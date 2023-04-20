package br.com.magna.animal.api.service;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.model.domain.Alimentacao;
import br.com.magna.animal.api.model.domain.Ambiente;
import br.com.magna.animal.api.model.domain.TipoMamifero;
import br.com.magna.animal.api.model.historic.MamiferoHistoric;
import br.com.magna.animal.api.record.DadosAtualizacaoMamiferoRecord;
import br.com.magna.animal.api.record.DadosCadastroMamiferoRecord;
import br.com.magna.animal.api.record.DadosDetalhamentoMamiferoRecord;
import br.com.magna.animal.api.repository.MamiferoRepository;
import br.com.magna.animal.api.repository.domain.AlimentacaoRepository;
import br.com.magna.animal.api.repository.domain.AmbienteRepository;
import br.com.magna.animal.api.repository.domain.TipoMamiferoRepository;
import br.com.magna.animal.api.repository.historic.MamiferoHistoricRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MamiferoService {

	@Autowired
	private MamiferoRepository mamiferoRepository;
	
	@Autowired
	private AlimentacaoRepository alimentacaoRepository;
	
	@Autowired
	private TipoMamiferoRepository tipoMamiferoRepository;
	
	@Autowired
	private AmbienteRepository ambienteRepository;

	@Autowired
	private MamiferoHistoricRepository mamiferoHistoricRepository;
	
	private String dbUser = "Admin";
	
	private String dbUser2 = "Admin2";
	
	List<String> nomes = Arrays.asList("Golfinho", "Baleia", "Peixe", 
			"Aquatico", "Marinho", "Boto", "Orca","Foca", "Urso", "Morsa");
	
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
		mamifero.setTipoMamifero(tipoMamifero.getNome());
		Alimentacao alimentacao = alimentacaoRepository.verificandoAlimentacao(dados.alimentacao());
		mamifero.setAlimentacao(alimentacao.getNome());
		
		if(dados.nome().contains("Morcego")) {
			Ambiente ambiente = ambienteRepository.verificandoAmbiente("Aereo");
			mamifero.setAmbiente(ambiente.getNome());
		}else if(nomes.stream().anyMatch(dados.nome()::contains)) {
			Ambiente ambiente = ambienteRepository.verificandoAmbiente("Aquatico");
			mamifero.setAmbiente(ambiente.getNome());
		}else {
			Ambiente ambiente = ambienteRepository.verificandoAmbiente("Terrestre");
			mamifero.setAmbiente(ambiente.getNome());
		}

		mamifero.setTimestampFirstCreated(ZonedDateTime.now());
		mamifero.setTimestampLastUpdate(ZonedDateTime.now());
		mamifero.setTimestampTimeZone(ZonedDateTime.now().getZone());
		
		mamiferoRepository.save(mamifero);
		
		MamiferoHistoric mamiferoHistoric = cadastrarMamiferoHistoric(mamifero);
		mamiferoHistoricRepository.save(mamiferoHistoric);
		
		return mamifero;
	}

	public Page<DadosDetalhamentoMamiferoRecord> listarTodos(Pageable paginacao) {
		return mamiferoRepository.findAll(paginacao).map(DadosDetalhamentoMamiferoRecord::new); 
	}

	public DadosDetalhamentoMamiferoRecord listarPorId(Long id) {
		var mamifero = mamiferoRepository.getReferenceById(id);
		return new DadosDetalhamentoMamiferoRecord(mamifero);
	}

	public Mamifero atualizarMamifero(DadosAtualizacaoMamiferoRecord dados) {
		Mamifero mamifero = mamiferoRepository.getReferenceById(dados.id());
		MamiferoHistoric mamiferoHistoric = cadastrarMamiferoHistoric(mamifero);
		mamiferoHistoricRepository.save(mamiferoHistoric);
		mamifero.atualizarInformacoes(dados);
		if(dados.nome().contains("Morcego")) {
			Ambiente ambiente = ambienteRepository.verificandoAmbiente("Aereo");
			mamifero.setAmbiente(ambiente.getNome());
		}else if(nomes.stream().anyMatch(dados.nome()::contains)) {
			Ambiente ambiente = ambienteRepository.verificandoAmbiente("Aquatico");
			mamifero.setAmbiente(ambiente.getNome());
		}else {
			Ambiente ambiente = ambienteRepository.verificandoAmbiente("Terrestre");
			mamifero.setAmbiente(ambiente.getNome());
		}
		mamifero.setUserDatabaseCreate(dbUser);
		mamifero.setUserDatabaseUpdate(dbUser2);
		mamifero.setTimestampLastUpdate(ZonedDateTime.now());
		mamiferoRepository.save(mamifero);
		return mamifero;
	}

	public void excluirMamifero(Long id) {
		try {
			mamiferoRepository.deleteById(id);
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
		mamiferoHistoric.setTipoMamifero(tipoMamifero.getNome());
		Alimentacao alimentacao = alimentacaoRepository.verificandoAlimentacao(mamifero.getAlimentacao());
		mamiferoHistoric.setAlimentacao(alimentacao.getNome());
		
		mamiferoHistoric.setUserDatabaseCreate(mamifero.getUserDatabaseCreate());
		mamiferoHistoric.setUserDatabaseUpdate(dbUser2);
		mamiferoHistoric.setTimestampFirstCreated(mamifero.getTimestampFirstCreated());
		mamiferoHistoric.setTimestampLastUpdate(ZonedDateTime.now());
		mamiferoHistoric.setTimestampTimeZone(ZonedDateTime.now().getZone());
		
		return mamiferoHistoric;
	}

}
