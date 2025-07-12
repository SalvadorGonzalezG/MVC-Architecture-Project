package com.mvc.archMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.archMVC.entities.Pelicula;
import com.mvc.archMVC.services.IPeliculaService;

@Controller
public class PeliculaController {
	
	@Autowired
	private IPeliculaService peliculaService;
	
	public PeliculaController(IPeliculaService peliculaService) {
		this.peliculaService = peliculaService;
	}
	@PostMapping("/pelicula")
	public String crear(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Nueva Pelicula");
		return "pelicula";
	}
	@GetMapping
	public String editar(@PathVariable (name="id") int id, Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Editar Pelicula");
		return "pelicula";
	}
	
	

}
