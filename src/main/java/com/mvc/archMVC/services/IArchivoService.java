package com.mvc.archMVC.services;

import java.io.InputStream;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;


public interface IArchivoService {

	// method save
	public void guardar(String archivo, InputStream bytes);
	
	public void eliminar(String archivo);
	
	// Devuelve un reponseEntity y recibe el nombre del archivo
	public ResponseEntity<Resource> get(String archivo);
	
	
}
