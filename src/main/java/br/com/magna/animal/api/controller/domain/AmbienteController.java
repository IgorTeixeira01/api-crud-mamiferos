package br.com.magna.animal.api.controller.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.animal.api.record.domain.DadosDetalhamentoAmbienteRecord;
import br.com.magna.animal.api.service.domain.AmbienteService;

@RestController
@RequestMapping("ambiente")
public class AmbienteController {
	
	@Autowired
	private AmbienteService service;
	
	@GetMapping(value = "/listagem") 
	public ResponseEntity<Page<DadosDetalhamentoAmbienteRecord>> listar(@PageableDefault(sort ="id", size = 10) Pageable paginacao){
		return ResponseEntity.ok(service.listarTodos(paginacao));
	}
	
}
