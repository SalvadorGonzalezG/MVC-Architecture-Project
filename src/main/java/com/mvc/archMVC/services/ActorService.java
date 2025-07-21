package com.mvc.archMVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.archMVC.dao.IActorRepository;
import com.mvc.archMVC.entities.Actor;

@Service
public class ActorService implements IActorService{

	@Autowired
	IActorRepository actorRepository;
	
	@Override
	public List<Actor> findAll(){
		return (List<Actor>) actorRepository.findAll();
	}
	
	@Override
	public List<Actor> findAllById(List<Integer> ids){
		return (List<Actor>) actorRepository.findAllById(ids);
	}
}
