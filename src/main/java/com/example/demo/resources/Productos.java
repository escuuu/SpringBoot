package com.example.demo.resources;

public class Productos {
	
	private Long id_producto;
	private String nombre;
	private String descripcion;
	private float precio;
	private int cantidad_inventario;
	
	public Productos(Long id_producto, String nombre, String descripcion, float precio, int cantidad_inventario) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad_inventario = cantidad_inventario;
	}

	public Productos(String nombre, String descripcion, float precio, int cantidad_inventario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad_inventario = cantidad_inventario;
	}

	public Productos() {
		super();
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad_inventario() {
		return cantidad_inventario;
	}

	public void setCantidad_inventario(int cantidad_inventario) {
		this.cantidad_inventario = cantidad_inventario;
	}
}
