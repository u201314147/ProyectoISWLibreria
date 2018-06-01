package pe.com.semana10.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Libro;

@Service
public interface LibroService {

	public List<Libro> listado();
	
	public Page<Libro> listadoConPaginacion(Pageable paginacion);
	
	public boolean agregar(Libro libro);
	
	public List<Libro> buscarPorPrecio(double precio);
	
	public List<Libro> buscarPorGenero(int genero);
	
	public List<Libro> buscarPorEditorial(int editorial);
	public Libro buscarPorID(int id);
	
}
