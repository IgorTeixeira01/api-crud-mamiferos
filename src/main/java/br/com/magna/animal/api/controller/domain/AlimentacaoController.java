package br.com.magna.animal.api.controller.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.animal.api.model.domain.Alimentacao;
import br.com.magna.animal.api.service.domain.AlimentacaoService;

@RestController
@RequestMapping("alimentacao")
public class AlimentacaoController {
	
	@Autowired
	private AlimentacaoService service;
	
	@GetMapping(value = "/listagem") 
	public ResponseEntity<Page<Alimentacao>> listar(@PageableDefault(sort ="id", size = 10) Pageable paginacao){
		return ResponseEntity.ok(service.listarTodos(paginacao));
	}
	
}
