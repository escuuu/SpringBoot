package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.pedidos.IPedidosDAO;
import com.example.demo.resources.Pedidos;

@Service
public class PedidosService {
	
	 @Autowired
	 IPedidosDAO pedidosDAO;
	 
	 public List<Pedidos> getAllPedidos() {
		 List<Pedidos> lista = pedidosDAO.getAllPedidos();
		 return lista;
	 }
}
