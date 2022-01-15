package com.ALTbruno.transportadoraapi.domain.service;

import com.ALTbruno.transportadoraapi.domain.exception.EntidadeNaoEncontradaException;
import com.ALTbruno.transportadoraapi.domain.exception.NegocioException;
import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import com.ALTbruno.transportadoraapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaEntregaService {

	@Autowired
	EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
