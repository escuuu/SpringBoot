package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.clientes.IClientesDAO;
import com.example.demo.resources.Clientes;
import com.example.demo.rest.ClientesException;

@Service
public class ClienteService {
	
	@Autowired
	IClientesDAO clientesDAO;
	
	
	public List<Clientes> getAllClients() {
		List<Clientes> listaClientes =  clientesDAO.searchAllClients();
		return listaClientes;
	}
	
	public Clientes getClient(Long id_cliente) {
		
		Optional<Clientes> foundedClient = clientesDAO.searchClient(id_cliente);
		
		if(foundedClient.isPresent()) {
			return foundedClient.get();
		} else {
			throw new ClientesException(id_cliente);
		}
	}
	
	public Clientes putClient(Clientes cliente) {
		
		Optional<Clientes> foundedClient = clientesDAO.searchClient(cliente.getId_cliente());
		
		if(foundedClient.isEmpty()) {
			Clientes clientCreated = clientesDAO.createClient(cliente);
			return clientCreated;
		} else {
			return null;	
		}
		
	}
	
	public void updateClient(Clientes cliente) {
		Optional<Clientes> nuevoClient = clientesDAO.searchClient(cliente.getId_cliente());
		
		if(nuevoClient.isPresent()) {
			clientesDAO.updatesClient(cliente);
		} else {
			throw new ClientesException(cliente.getId_cliente());
		}
	}
	
	public Clientes deleteClient(Long id_cliente) {
		Optional<Clientes> foundedClient = clientesDAO.searchClient(id_cliente);
		
		if(foundedClient.isPresent()) {
			Clientes removedClient = clientesDAO.deleteClient(foundedClient.get());
			return removedClient;
		} else {
			return null;
		}
	}

}
