package com.example.demo.resources;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedidos {
	
	private enum Estado{
		pendiente,
		en_proceso,
		entregado,
		cancelado,
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_pedido;
	
	@Column(nullable = false)
	private String fecha_creacion;
	
	@Column(nullable = false)
	private Estado estado;
	
    @JoinTable(
            name = "detalles_productos",
            joinColumns = @JoinColumn(name= "fk_pedido", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_producto", nullable = false)
        )
    @OneToMany(cascade = CascadeType.ALL)
	@Column(nullable = false)
	private List<Productos> productos;
	
    @ManyToOne
    @JoinColumn(name = "fk_cliente", nullable = false, updatable = false)
	private Clientes cliente;
	
	public Pedidos(Long id_pedido, String fecha_creacion, Estado estado, List<Productos> productos, Clientes cliente) {
		super();
		this.id_pedido = id_pedido;
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;
		this.productos = productos;
		this.cliente = cliente;
	}

	public Pedidos(String fecha_creacion, Estado estado, List<Productos> productos, Clientes cliente) {
		super();
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;
		this.productos = productos;
		this.cliente = cliente;
	}

	public Pedidos() {
		super();
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	
	
}
