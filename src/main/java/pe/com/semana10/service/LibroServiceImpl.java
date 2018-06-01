package pe.com.semana10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Libro;
import pe.com.semana10.repositorio.AutorRepositorio;
import pe.com.semana10.repositorio.LibroRepositorio;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepositorio repositorioInterface;
	
	@Override
	public List<Libro> listado() {
		List<Libro> libros = repositorioInterface.findAll();
		
		return libros;
	}
	
	@Override
	public Page<Libro> listadoConPaginacion(Pageable paginacion) {
		// TODO Auto-generated method stub
		Page<Libro> libros = repositorioInterface.findAll(paginacion);
		
		return libros;
	}

	@Override
	public boolean agregar(Libro libro) {
		// TODO Auto-generated method stub
		Libro objLibro = repositorioInterface.save(libro);
		if (objLibro == null){
			return false;
		}else{
			return true;
		}		
	}

	@Override
	public List<Libro> buscarPorPrecio(double precio) {
		// TODO Auto-generated method stub
		return repositorioInterface.buscarPorPrecio(precio);
	}

	@Override
	public Libro buscarPorID(int id) {
		// TODO Auto-generated method stub
		
		return repositorioInterface.findOne(id);
	}

	@Override
	public List<Libro> buscarPorGenero(int genero) {
		// TODO Auto-generated method stub
		
		return  repositorioInterface.buscarPorGenero(genero);
	}

	@Override
	public List<Libro> buscarPorEditorial(int editorial) {
		// TODO Auto-generated method stub
		return  repositorioInterface.buscarPorGenero(editorial);
	}

	


}
