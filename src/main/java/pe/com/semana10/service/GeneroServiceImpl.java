package pe.com.semana10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Genero;
import pe.com.semana10.repositorio.AutorRepositorio;
import pe.com.semana10.repositorio.GeneroRepositorio;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepositorio repositorioInterface;
	
	@Override
	public List<Genero> listado() {
		List<Genero> generos = repositorioInterface.findAll();
		
		return generos;
	}

}
