package com.mvc.archMVC.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="genero")
public class Genero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7473686313525806327L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	// Getters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
