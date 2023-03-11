package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.pedidos.IPedidosDAO;
import com.example.demo.resources.Pedidos;
import com.example.demo.rest.ClientesException;

@Service
public class PedidosService {
	
	 @Autowired
	 IPedidosDAO pedidosDAO;
	 
	 public List<Pedidos> getAllPedidos() {
		 List<Pedidos> lista = pedidosDAO.getAllPedidos();
		 return lista;
	 }
	 
	 public Pedidos getPedidos(Long id_pedido) {
		 
		 Optional<Pedidos> founded = pedidosDAO.getPedido(id_pedido);
		 
		 if(founded.isPresent()) {
			 return founded.get();
		 } else {
			 throw new ClientesException(id_pedido);
		 }
	 }
	 
	 public Pedidos createPedido(Pedidos pedido) {
		 
		 Optional<Pedidos> founded = pedidosDAO.getPedido(pedido.getId_pedido());
		 
		 if(founded.isEmpty()) {
			 Pedidos pedidoCreado = pedidosDAO.createPedidos(pedido);
			 
			 return pedidoCreado;
		 } else {
			 return null;
		 }
	 }
	 
	 public boolean updatePedido(Pedidos pedido) {
		 
		 Optional<Pedidos> founded = pedidosDAO.getPedido(pedido.getId_pedido());
		 
		 if(founded.isPresent()) {
			 boolean respuesta = pedidosDAO.updatePedidos(pedido);
			 
			 return respuesta;
			 
		 } else {
			 throw new ClientesException(pedido.getId_pedido());
		 }
		 
	 }
	 
	 
	 public boolean deletePedido(Long id_pedido) {
		 
		 Optional<Pedidos> founded = pedidosDAO.getPedido(id_pedido);
		 
		 if(founded.isPresent()) {
			 boolean respuesta = pedidosDAO.deletePedido(founded.get());
			 
			 return respuesta;
		 } else {
			 throw new ClientesException(id_pedido);
		 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
