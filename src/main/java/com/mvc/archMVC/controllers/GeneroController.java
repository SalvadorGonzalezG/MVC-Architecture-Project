package com.mvc.archMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.archMVC.entities.Genero;
import com.mvc.archMVC.services.IGeneroService;

@RestController
public class GeneroController {
	
	@Autowired
	public IGeneroService generoService;
	
	public GeneroController(IGeneroService generoService) {
		this.generoService = generoService;
	}
	@PostMapping("/genero")
	public int GuardarUnGenero(@RequestParam String  nombre) {
		Genero genero = new Genero();
		genero.setNombre(nombre);
		generoService.save(genero);
		return genero.getId();
	}
	
	@GetMapping("/genero/{id}")
	public String buscarPorId(@PathVariable(name="id") int id) {
		return generoService.findById(id).getNombre();
	}

}
