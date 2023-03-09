package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.demo.resources.Clientes;
import com.example.demo.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ClientesController {

	@Autowired
	private ClienteService service;
	
	@PostMapping(path = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clientes> addCliente(@RequestBody @Valid Clientes cliente) throws URISyntaxException {
		
		Clientes new_client = service.putClient(cliente);
		
		return ResponseEntity.created(new URI("/clientes/" + new_client.getId_cliente())).body(new_client);	
	}
	
	@GetMapping("/clientes")
	public List<Clientes> getAllClients() {
		return service.getAllClients();
	}
	
	@GetMapping(path = "/clientes/{id_cliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Clientes getClient(@PathVariable Long id_cliente) {
		return service.getClient(id_cliente);
	}
	
	@PutMapping(path = "/clientes/{id_cliente}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clientes> updateClient(@RequestBody @Valid Clientes cliente, @PathVariable Long id_cliente) {
		service.updateClient(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping(path = "/clientes/{id_cliente}")
	public ResponseEntity<Clientes> deleteClient(@PathVariable Long id_cliente) {
		Clientes removed_client = service.deleteClient(id_cliente);
		
		return ResponseEntity.ok(removed_client);
	}
}
