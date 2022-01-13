package com.ALTbruno.transportadoraapi.api.controller;

import com.ALTbruno.transportadoraapi.domain.model.Cliente;
import com.ALTbruno.transportadoraapi.domain.repository.ClienteRepository;
import com.ALTbruno.transportadoraapi.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@GetMapping
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

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();

		return clienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

		return clienteService.salvar(cliente);
	}

	@PutMapping("{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {

		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(clienteId);
		cliente = clienteService.salvar(cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> deletar(@PathVariable Long clienteId) {

		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		clienteService.excluir(clienteId);

		return ResponseEntity.noContent().build();
	}
}
