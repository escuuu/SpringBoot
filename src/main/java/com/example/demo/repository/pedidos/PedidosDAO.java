package com.example.demo.repository.pedidos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.example.demo.resources.Pedidos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PedidosDAO implements IPedidosDAO{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Pedidos> getAllPedidos() {
		TypedQuery<Pedidos> consulta = em.createQuery("SELECT p FROM PEDIDOS p", Pedidos.class);
		
		return consulta.getResultList();
	}
	
	@Override
	public Optional<Pedidos> getPedido(Long id_pedido) {
		return Optional.of(em.find(Pedidos.class, id_pedido));
	}
	
	@Transactional
	public Pedidos createPedidos(Pedidos pedido) {
		
		em.persist(pedido);
		return pedido;
	}
	
	@Transactional
	public boolean updatePedidos(Pedidos pedido) {
		em.merge(pedido);
		
		return true;
	}
	
	public boolean deletePedido(Pedidos pedido) {
		em.remove(pedido);
		
		return true;
	}
}
