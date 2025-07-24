package com.mvc.archMVC.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.archMVC.entities.Actor;
import com.mvc.archMVC.entities.Pelicula;
import com.mvc.archMVC.services.IActorService;
import com.mvc.archMVC.services.IGeneroService;
import com.mvc.archMVC.services.IPeliculaService;

import jakarta.validation.Valid;

@Controller
public class PeliculaController {
	
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private IGeneroService generoService;
	
	@Autowired
	private IActorService actorService;
	
	
	public PeliculaController(IPeliculaService peliculaService, IGeneroService generoService, IActorService actorService) {
		this.peliculaService = peliculaService;
		this.generoService = generoService;
		this.actorService = actorService;
	}
	@GetMapping("/pelicula")
	public String crear(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generoService.findAll()); //Trasladamos generos a la vista Para implementarlo en un select
		model.addAttribute("actores", actorService.findAll());
		model.addAttribute("titulo", "Nueva Pelicula");
		return "pelicula";
	}
	@GetMapping("/pelicula/{id}")
	public String editar(@PathVariable (name="id") int id, Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generoService.findAll());
		model.addAttribute("actores", actorService.findAll());
		model.addAttribute("pelicula", peliculaService.findById(id));
		model.addAttribute("titulo", "Editar Pelicula");
		return "pelicula";
	}
	
	@PostMapping("/pelicula")
	public String guardar(@Valid Pelicula pelicula, BindingResult br, @ModelAttribute(name="ids") String ids, Model model) {
		
		if(br.hasErrors()) {
			model.addAttribute("generos", generoService.findAll());
	        model.addAttribute("actores", actorService.findAll());
	        model.addAttribute("titulo", "Nueva Película");
			return "pelicula";
		}
		List<Integer> idsProtagonistas = Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		List<Actor> protagonistas = (List<Actor>) actorService.findAllById(idsProtagonistas);
		pelicula.setProtagonista(protagonistas);
		peliculaService.create(pelicula);
		return "redirect:/home";
	}
	
	@GetMapping({"/", "/home", "/index"})
	public String home(Model model) {
		model.addAttribute("peliculas", peliculaService.findAll());
		model.addAttribute("msj", "Catalogo");
		model.addAttribute("tipoMsj", "success");
		return "home";
	}
	
	

}
