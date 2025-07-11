package com.mvc.archMVC.services;

import java.util.List;

import com.mvc.archMVC.entities.Genero;

public interface IGeneroService {

	//Abstract Methods
	public void save(Genero genero);	
	public void delete(int id);	
	public Genero findById(int id);
	public List<Genero> findAll();
	
	
}
