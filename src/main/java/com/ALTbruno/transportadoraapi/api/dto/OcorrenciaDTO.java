package com.ALTbruno.transportadoraapi.api.dto;

import java.time.OffsetDateTime;

public class OcorrenciaDTO {

	private Long id;
	private String description;
	private OffsetDateTime dataRegistro;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(OffsetDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
}
