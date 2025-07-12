package com.mvc.archMVC.services;

import java.util.List;

import com.mvc.archMVC.entities.Pelicula;

public interface IPeliculaService {
	
	//Abstract Methods
	public void create(Pelicula pelica);
	
	public Pelicula findById(int id);
	
	public void delete(int id);
	
	public List<Pelicula> findA();

}
