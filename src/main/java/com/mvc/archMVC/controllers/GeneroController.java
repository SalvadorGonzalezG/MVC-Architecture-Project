package com.mvc.archMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.archMVC.dao.IGeneroRepository;
import com.mvc.archMVC.entities.Genero;

@RestController
public class GeneroController {
	
	@Autowired
	public IGeneroRepository generoRepository;
	
	public GeneroController(IGeneroRepository generoRepository) {
		this.generoRepository = generoRepository;
	}
	@PostMapping("/genero")
	public int GuardarUnGenero(@RequestParam String  nombre) {
		Genero genero = new Genero();
		genero.setNombre(nombre);
		generoRepository.save(genero);
		return genero.getId();
	}
	
	@GetMapping("genero/{nombre}/{id}")
	public String buscarPorId(@PathVariable(name="id") int id) {
		return generoRepository.findById(0).getNombre();
	}

}
