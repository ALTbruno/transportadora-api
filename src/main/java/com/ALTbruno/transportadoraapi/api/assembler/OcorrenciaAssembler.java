package com.ALTbruno.transportadoraapi.api.assembler;

import com.ALTbruno.transportadoraapi.api.dto.OcorrenciaDTO;
import com.ALTbruno.transportadoraapi.domain.model.Ocorrencia;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OcorrenciaAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public OcorrenciaDTO toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}

	public List<OcorrenciaDTO> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
