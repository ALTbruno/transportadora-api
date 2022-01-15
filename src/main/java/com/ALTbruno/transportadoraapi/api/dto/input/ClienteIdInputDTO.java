package com.ALTbruno.transportadoraapi.api.dto.input;

import javax.validation.constraints.NotNull;

public class ClienteIdInputDTO {

	@NotNull
	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
