package pe.com.semana10.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Genero;
import pe.com.semana10.model.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Integer>, PagingAndSortingRepository<Libro, Integer > {

	
	public List<Libro> buscarPorPrecio(double precio);
	
	public List<Libro> buscarPorGenero(int genero);
	public List<Libro> buscarPorEditorial(int editorial);
	
}
