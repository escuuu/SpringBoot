package com.example.demo.repository.pedidos;

import java.util.List;
import java.util.Optional;

import com.example.demo.resources.Pedidos;

public interface IPedidosDAO {

	List<Pedidos> getAllPedidos();

	Optional<Pedidos> getPedido(Long id_pedido);
	
	Pedidos createPedidos(Pedidos pedido);
	
	boolean updatePedidos(Pedidos pedido);
	
	boolean deletePedido(Pedidos pedido);
}
