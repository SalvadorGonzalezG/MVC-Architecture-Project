package com.mvc.archMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mvc.archMVC.entities.Pelicula;
import com.mvc.archMVC.services.IGeneroService;
import com.mvc.archMVC.services.IPeliculaService;

@Controller
public class PeliculaController {
	
	@Autowired
	private IPeliculaService peliculaService;
	private IGeneroService generoService;
	
	
	public PeliculaController(IPeliculaService peliculaService, IGeneroService generoService) {
		this.peliculaService = peliculaService;
		this.generoService = generoService;
	}
	@GetMapping("/pelicula")
	public String crear(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("genero", generoService.findAll()); //Trasladamos generos a la vista Para implementarlo en un select
		model.addAttribute("titulo", "Nueva Pelicula");
		return "pelicula";
	}
	@GetMapping("/pelicula/{id}")
	public String editar(@PathVariable (name="id") int id, Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Editar Pelicula");
		return "pelicula";
	}
	
	

}
