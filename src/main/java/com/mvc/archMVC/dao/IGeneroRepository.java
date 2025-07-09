package com.mvc.archMVC.dao;

import com.mvc.archMVC.entities.Genero;

public interface IGeneroRepository {

	// Methods Abstracts
	
	// Save an object of type Genre
	public void save(Genero Genero);
	
	//Search for a genre by its ID
	public String findById(Long id);
}
