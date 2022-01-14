package com.ALTbruno.transportadoraapi.domain.service;

import com.ALTbruno.transportadoraapi.domain.exception.NegocioException;
import com.ALTbruno.transportadoraapi.domain.model.Cliente;
import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import com.ALTbruno.transportadoraapi.domain.model.StatusEntrega;
import com.ALTbruno.transportadoraapi.domain.repository.ClienteRepository;
import com.ALTbruno.transportadoraapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class EntregaService {

	@Autowired
	EntregaRepository entregaRepository;

	@Autowired
	ClienteService clienteService;

	@Transactional
	public Entrega solicitar(Entrega entrega) {

		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());

		return entregaRepository.save(entrega);
	}
}
