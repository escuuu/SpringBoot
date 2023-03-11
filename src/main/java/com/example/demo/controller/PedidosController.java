package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resources.Pedidos;
import com.example.demo.services.PedidosService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class PedidosController {
	
	@Autowired
	private PedidosService ps;
	
	@PostMapping(path = "/pedidos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedidos> crearPedido(@RequestBody @Valid Pedidos pedido) throws URISyntaxException {
		
		Pedidos pedidoCreado = ps.createPedido(pedido);
		
		return ResponseEntity.created(new URI("/pedidos" + pedidoCreado.getId_pedido())).body(pedidoCreado);
 	}
	
	@GetMapping(path= "/pedidos")
	public List<Pedidos> getAllClients() {
		
		List<Pedidos> listaPedidos = ps.getAllPedidos();
		
		return listaPedidos;
	}
	
	@GetMapping(path= "/pedidos/{id_pedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedidos getPedido(@PathVariable Long id_pedido) {
		
		return ps.getPedidos(id_pedido);
	}
	
	public ResponseEntity<Pedidos> updatePedido(@RequestBody @Valid Pedidos pedido) {
		
		ps.updatePedido(pedido);
		
		return ResponseEntity.ok(pedido);
	}
	
	
}
