package br.com.magna.animal.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magna.animal.api.dto.MamiferoAtualizacaoDTO;
import br.com.magna.animal.api.dto.MamiferoCadastroDTO;
import br.com.magna.animal.api.model.Mamifero;
import br.com.magna.animal.api.service.MamiferoService;

@RestController
@RequestMapping("mamiferos")
public class MamiferoController {
	
	@Autowired
	private MamiferoService service;
	
	@PostMapping(value = "/cadastrar")
    @Transactional
	public ResponseEntity<Mamifero> cadastrar(@RequestBody @Validated MamiferoCadastroDTO dados, UriComponentsBuilder uriBuilder) {
		Mamifero mamifero = service.cadastrarMamifero(dados);
		URI uri = uriBuilder.path("/mamiferos/{id}").buildAndExpand(mamifero.getId()).toUri(); 
        return ResponseEntity.created(uri).body(service.listarPorId(mamifero.getId()));
	}
	
	@GetMapping(value = "/listagem") 
	public ResponseEntity<Page<Mamifero>> listar(@PageableDefault(sort ="id", size = 10)Pageable paginacao){
        return ResponseEntity.ok(service.listarTodos(paginacao));
	}
	
	@GetMapping("/detalhar/{id}")
	public ResponseEntity<Mamifero> detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarPorId(id));
	}

	
	@PutMapping(value = "/atualizar")
	@Transactional
	public ResponseEntity<Mamifero> atualizar(@RequestBody @Validated MamiferoAtualizacaoDTO dados) {
		return ResponseEntity.ok(service.atualizarMamifero(dados));
	}
	
	@DeleteMapping("excluir/{id}")
	@Transactional
	public ResponseEntity<String> excluir(@PathVariable Long id) {
		service.excluirMamifero(id);
		return ResponseEntity.noContent().build();
	}
	
}
