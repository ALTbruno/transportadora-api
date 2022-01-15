package com.ALTbruno.transportadoraapi.api.assembler;

import com.ALTbruno.transportadoraapi.api.dto.EntregaDTO;
import com.ALTbruno.transportadoraapi.api.dto.input.EntregaInputDTO;
import com.ALTbruno.transportadoraapi.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public EntregaDTO toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}

	public List<EntregaDTO> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

	public Entrega toEntity(EntregaInputDTO entregaInputDTO) {
		return modelMapper.map(entregaInputDTO, Entrega.class);
	}
}
