package com.mvc.archMVC.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="actor")
public class Actor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5451155622979537530L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@Column(name="url_imagen")
	private String urlImagen;
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

}
