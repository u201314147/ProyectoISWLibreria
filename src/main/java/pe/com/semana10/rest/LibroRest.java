package pe.com.semana10.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Libro;
import pe.com.semana10.service.LibroService;

@RestController
//@ResponseBody
public class LibroRest {
@Autowired
LibroService libroService;
	
	
	@RequestMapping("/autoresLibro/{id}")
	public List<Autor> obtenerAutores(@PathVariable int id){
	
	Libro objLibro = libroService.buscarPorID(id);
	List<Autor> autores = new ArrayList<Autor>();
	
	Autor objAutor=null;
	
	for(int i=0; i<objLibro.getAutores().size();i++)
	{
	objAutor=new Autor();
	objAutor.setId(objLibro.getAutores().get(i).getId());
	objAutor.setApellidos(objLibro.getAutores().get(i).getApellidos());
	objAutor.setNacionalidad(objLibro.getAutores().get(i).getNacionalidad());
	autores.add(objAutor);
	}
	return autores;
	}
}
