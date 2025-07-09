package com.mvc.archMVC.dao;

import org.springframework.stereotype.Repository;

import com.mvc.archMVC.entities.Genero;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class GeneroRepository implements IGeneroRepository{

	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Genero genero) {
		entityManager.persist(genero); // Inserts the object into the database
	}
	
	@Override
	@Transactional
	public Genero findById(int id) {
		return entityManager.find(Genero.class, id); // Search by ID using JPA
	}
	
}
