package com.ALTbruno.transportadoraapi.api.controller;

import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import com.ALTbruno.transportadoraapi.domain.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaService entregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@RequestBody Entrega entrega) {

		return entregaService.solicitar(entrega);
	}
}
