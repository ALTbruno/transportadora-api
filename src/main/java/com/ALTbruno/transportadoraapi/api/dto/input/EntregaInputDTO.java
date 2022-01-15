package com.ALTbruno.transportadoraapi.api.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class EntregaInputDTO {

	@Valid
	@NotNull
	private ClienteIdInputDTO cliente;

	@Valid
	@NotNull
	private DestinatarioInputDTO destinatario;

	@NotNull
	private BigDecimal taxa;


	public ClienteIdInputDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInputDTO cliente) {
		this.cliente = cliente;
	}

	public DestinatarioInputDTO getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioInputDTO destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
}
