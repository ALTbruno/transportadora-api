package com.ALTbruno.transportadoraapi.api.dto.input;

import javax.validation.constraints.NotBlank;

public class OcorrenciaInputDTO {

	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
