package pe.com.semana10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Editorial;
import pe.com.semana10.model.Genero;
import pe.com.semana10.repositorio.AutorRepositorio;
import pe.com.semana10.repositorio.EditorialRepositorio;
import pe.com.semana10.repositorio.GeneroRepositorio;

@Service
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialRepositorio repositorioInterface;
	
	@Override
	public List<Editorial> listado() {
		List<Editorial> editoriales = repositorioInterface.findAll();
		
		return editoriales;
	}

}
