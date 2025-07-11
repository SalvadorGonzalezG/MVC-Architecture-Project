package com.mvc.archMVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.archMVC.dao.IGeneroRepository;
import com.mvc.archMVC.entities.Genero;

@Service
public class GeneroService implements IGeneroService{
	
	@Autowired
	private IGeneroRepository generoServide;
	
	@Override
	public void save(Genero genero) {
		generoServide.save(genero);
	}
	
	@Override
	public void delete(int id) {
		generoServide.deleteById(id);
	}
	
	@Override
	public Genero findById(int id) {
		return generoServide.findById(id).orElse(null);
	}
	
	@Override
	public List<Genero> findAll(){
		return (List<Genero>) generoServide.findAll();
	}

}
