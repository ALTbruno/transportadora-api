package com.ALTbruno.transportadoraapi.controller;

import com.ALTbruno.transportadoraapi.domain.model.Cliente;
import com.ALTbruno.transportadoraapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

//	@GetMapping("/clientes")
//	public List<Cliente> listarPorNome() {
//		return clienteRepository.findByNome("Bruno");
//	}

//	@GetMapping("/clientes")
//	public List<Cliente> listarPorNome() {
//		return clienteRepository.findByNomeContaining("Bru");
//	}
}
