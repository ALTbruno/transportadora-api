package com.ALTbruno.transportadoraapi.api.controller;

import com.ALTbruno.transportadoraapi.api.dto.DestinatarioDTO;
import com.ALTbruno.transportadoraapi.api.dto.EntregaDTO;
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
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					EntregaDTO entregaDTO = new EntregaDTO();
					entregaDTO.setId(entrega.getId());
					entregaDTO.setNomeCliente(entrega.getCliente().getNome());
					entregaDTO.setDestinatario(new DestinatarioDTO());
					entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
					entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
					entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
					entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
					entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
					entregaDTO.setTaxa(entrega.getTaxa());
					entregaDTO.setStatus(entrega.getStatus());
					entregaDTO.setDataPedido(entrega.getDataPedido());
					entregaDTO.setDataFinalizacao(entrega.getDataFinalizacao());
					return ResponseEntity.ok(entregaDTO);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
