package pe.com.semana10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.semana10.model.Autor;

@Service
public interface AutorService {

	public Autor buscarPorId(int id);
	
	public List<Autor> buscarPorNombre(String nombre);
	public List<Autor> listado();
	
	public boolean agregar(Autor autor);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(Autor autor);
	
}
