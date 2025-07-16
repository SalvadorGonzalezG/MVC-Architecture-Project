package com.mvc.archMVC.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="pelicula")
public class Pelicula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -65977430776412433L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_estreno")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEstreno;
	@OneToOne
	private Genero genero;
	@OneToMany
	private List<Actor> protagonista;
	
	// getters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	@OneToOne
	public Genero getGenero() {
		return genero;
	}
	public List<Actor> getProtagonista(){
		return protagonista;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public void setProtagonistas(List<Actor> protagonista) {
		this.protagonista = protagonista;
	}
	
	

}
