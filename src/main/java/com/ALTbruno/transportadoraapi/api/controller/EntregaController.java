package com.ALTbruno.transportadoraapi.api.controller;

import com.ALTbruno.transportadoraapi.api.assembler.EntregaAssembler;
import com.ALTbruno.transportadoraapi.api.dto.DestinatarioDTO;
import com.ALTbruno.transportadoraapi.api.dto.EntregaDTO;
import com.ALTbruno.transportadoraapi.api.dto.input.EntregaInputDTO;
import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import com.ALTbruno.transportadoraapi.domain.repository.EntregaRepository;
import com.ALTbruno.transportadoraapi.domain.service.EntregaService;
import org.modelmapper.ModelMapper;
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

	@Autowired
	private EntregaAssembler entregaAssembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInputDTO entregaInputDTO) {

		Entrega novaEntrega = entregaAssembler.toEntity(entregaInputDTO);
		Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);
		return entregaAssembler.toModel(entregaService.solicitar(entregaSolicitada));
	}

	@GetMapping
	public List<EntregaDTO> listar() {

		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}

}
