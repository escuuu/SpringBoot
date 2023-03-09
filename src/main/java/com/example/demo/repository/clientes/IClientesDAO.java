package com.example.demo.repository.clientes;

import java.util.List;
import java.util.Optional;

import com.example.demo.resources.Clientes;

public interface IClientesDAO{

	List<Clientes> searchAllClients();

	Optional<Clientes> searchClient(Long id_cliente);
	
	Clientes createClient(Clientes cliente);
	
	void updatesClient(Clientes cliente);

	Clientes deleteClient(Clientes cliente);
}
