package com.ALTbruno.transportadoraapi.api.controller;

import com.ALTbruno.transportadoraapi.api.assembler.OcorrenciaAssembler;
import com.ALTbruno.transportadoraapi.api.dto.OcorrenciaDTO;
import com.ALTbruno.transportadoraapi.api.dto.input.OcorrenciaInputDTO;
import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import com.ALTbruno.transportadoraapi.domain.model.Ocorrencia;
import com.ALTbruno.transportadoraapi.domain.service.BuscaEntregaService;
import com.ALTbruno.transportadoraapi.domain.service.RegistroOcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;

	@Autowired
	private OcorrenciaAssembler ocorrenciaAssembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInputDTO ocorrenciaInputDTO) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrenciaInputDTO.getDescricao());

		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}

	@GetMapping
	public List<OcorrenciaDTO> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);

		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
}
