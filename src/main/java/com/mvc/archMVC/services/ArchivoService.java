package com.mvc.archMVC.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ArchivoService implements IArchivoService{

	@Override
	public void guardar(String archivo, InputStream bytes) {
		try {
			Files.copy(bytes, resolvePath(archivo));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override //Recuperamos Imgs atravez de http
	public ResponseEntity<Resource> get(String archivo){
		Resource resource = null;
		try {
			resource = new UrlResource(resolvePath(archivo).toUri());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; file\"" + resource.getFilename() + "\"" )
				.body(resource);
	}
	
	private Path resolvePath(String archivo) {
		return Paths.get("archivos").resolve(archivo).toAbsolutePath();
	}
}
