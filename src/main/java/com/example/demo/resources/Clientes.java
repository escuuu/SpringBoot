package com.example.demo.resources;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_cliente;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellidos;
	
	@Column(nullable = true)
	private String descripcion;
	
	@Column(nullable = false)
	private String correo;
	
	@Column
	private String direccion;
	
	public Clientes() {
		
	}
	
	public Clientes(Long id_cliente, String nombre, String apellidos, String descripcion, String correo,
			String direccion) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.correo = correo;
		this.direccion = direccion;
	}


	public Clientes(String nombre, String apellidos, String descripcion, String correo, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.correo = correo;
		this.direccion = direccion;
	}

	public Long getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
