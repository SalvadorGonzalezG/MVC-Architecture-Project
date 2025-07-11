package com.mvc.archMVC.dao;

import org.springframework.data.repository.CrudRepository;

import com.mvc.archMVC.entities.Genero;

public interface IGeneroRepository extends CrudRepository<Genero, Integer>{

	// Methods Abstracts
	
	// Save an object of type Genre
	/*public void save(Genero Genero);
	
	//Search for a genre by its ID
	public Genero findById(int id);*/
}
