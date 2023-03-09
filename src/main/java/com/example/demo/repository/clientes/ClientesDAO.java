package com.example.demo.repository.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.resources.Clientes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ClientesDAO implements IClientesDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Clientes> searchAllClients() {
		
		TypedQuery<Clientes> consulta = em.createQuery("select c from clientes c", Clientes.class);
		return consulta.getResultList();
	}
	
	@Override
	public Optional<Clientes> searchClient(Long id_cliente) {
		return Optional.of(em.find(Clientes.class, id_cliente));
	}
	
	@Transactional
	public Clientes createClient(Clientes cliente) {
		em.persist(cliente);
		return cliente;
	}
	
	@Transactional
	public void updatesClient(Clientes cliente) {
		em.merge(cliente);
	}
	
	@Transactional
	public Clientes deleteClient(Clientes cliente) {
		em.remove(cliente);
		
		return cliente;
	}

}
