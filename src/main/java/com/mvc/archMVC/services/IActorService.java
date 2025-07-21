package com.mvc.archMVC.services;

import java.util.List;

import com.mvc.archMVC.entities.Actor;

public interface IActorService {
	
	// Method buscar una todos los actores
	public List<Actor> findAll();
	
	// Method regresar una lista de todos los Actores en base a todos los ids que le mande
	public List<Actor> findAllById(List<Integer> ids );

}
