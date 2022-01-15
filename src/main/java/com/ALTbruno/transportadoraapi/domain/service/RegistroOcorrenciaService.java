package com.ALTbruno.transportadoraapi.domain.service;

import com.ALTbruno.transportadoraapi.domain.exception.NegocioException;
import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import com.ALTbruno.transportadoraapi.domain.model.Ocorrencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroOcorrenciaService {

	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);

		return entrega.adicionarOcorrencia(descricao);
	}
}
