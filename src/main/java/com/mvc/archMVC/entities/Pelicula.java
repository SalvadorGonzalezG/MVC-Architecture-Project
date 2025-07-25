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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
	@NotEmpty(message = "El nombre es obligatorio")
	private String nombre;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_estreno")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull()
	private Date fechaEstreno;
	@ManyToOne
	@NotNull()
	private Genero genero;
	@ManyToMany
	private List<Actor> protagonista;
	
	//Campo qie tendra URL de la imagen
	public String imagen;
	
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
	public Genero getGenero() {
		return genero;
	}
	public List<Actor> getProtagonista(){
		return protagonista;
	}
	public String getImagen() {
		return imagen;
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
	public void setProtagonista(List<Actor> protagonista) {
		this.protagonista = protagonista;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	

}
