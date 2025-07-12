package com.mvc.archMVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.archMVC.dao.IPeliculaRepository;
import com.mvc.archMVC.entities.Pelicula;

@Service
public class PeliculaService implements IPeliculaService{
	
	@Autowired
	private IPeliculaRepository peliculaRepository;

	@Override
	public void create(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}
	
	@Override
	public Pelicula findById(int id) {
		return peliculaRepository.findById(id).orElse(null);
	}
	
	@Override
	public void delete(int id) {
		peliculaRepository.deleteById(id);
	}
	
	@Override
	public List<Pelicula> findAll(){
		return (List<Pelicula>) peliculaRepository.findAll();
	}
	
}
