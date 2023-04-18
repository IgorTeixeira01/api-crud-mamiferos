package br.com.magna.animal.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.record.DadosAtualizacaoMamiferoRecord;
import br.com.magna.animal.api.record.DadosCadastroMamiferoRecord;
import br.com.magna.animal.api.record.DadosListagemCadastroMamiferoRecord;
import br.com.magna.animal.api.record.DadosListagemMamiferoRecord;
import br.com.magna.animal.api.service.MamiferoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("mamiferos")
public class MamiferoController {
	
	@Autowired
	private MamiferoService service;
	
	@PostMapping(value = "/cadastrar")
    @Transactional
	public ResponseEntity<DadosListagemCadastroMamiferoRecord> cadastrar(@RequestBody @Valid DadosCadastroMamiferoRecord dados, UriComponentsBuilder uriBuilder) {
		Mamifero mamifero = service.cadastrarMamifero(dados);
		var uri = uriBuilder.path("/mamiferos/{id}").buildAndExpand(mamifero.getId()).toUri(); 
        return ResponseEntity.created(uri).body(new DadosListagemCadastroMamiferoRecord(mamifero));
	}
	
	@GetMapping(value = "/listagem") 
	public ResponseEntity<Page<DadosListagemMamiferoRecord>> listar(@PageableDefault(sort ="id", size = 10)Pageable paginacao){
        return ResponseEntity.ok(service.listarTodos(paginacao));
	}
	
	@GetMapping("/listagem/{id}")
	public ResponseEntity<DadosListagemMamiferoRecord> listarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarPorId(id));
	}
	
	@PutMapping(value = "/atualizar")
	@Transactional
	public ResponseEntity<DadosListagemMamiferoRecord> atualizar(@RequestBody @Valid DadosAtualizacaoMamiferoRecord dados) {
		return ResponseEntity.ok(new DadosListagemMamiferoRecord(service.atualizarMamifero(dados)));
	}
	
	@DeleteMapping("excluir/{id}")
	@Transactional
	public ResponseEntity<String> excluir(@PathVariable Long id) {
		service.excluirMamifero(id);
		return ResponseEntity.noContent().build();
	}
	
}
