package com.ALTbruno.transportadoraapi.controller;

import com.ALTbruno.transportadoraapi.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {

		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Bruno");
		cliente1.setEmail("email@mail.com");
		cliente1.setTelefone("00000000000");

		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Nome Cliente");
		cliente2.setEmail("email@mail.com");
		cliente2.setTelefone("00000000000");

		return Arrays.asList(cliente1, cliente2);
	}
}
