package com.ALTbruno.transportadoraapi.api.controller;

import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import com.ALTbruno.transportadoraapi.domain.repository.EntregaRepository;
import com.ALTbruno.transportadoraapi.domain.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private EntregaService entregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {

		return entregaService.solicitar(entrega);
	}

	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
