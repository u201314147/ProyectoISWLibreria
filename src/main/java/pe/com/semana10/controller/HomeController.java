package pe.com.semana10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.semana10.model.Libro;
import pe.com.semana10.service.AutorService;
import pe.com.semana10.service.EditorialService;
import pe.com.semana10.service.GeneroService;
import pe.com.semana10.service.LibroService;

@Controller
public class HomeController {
	
	@Autowired
	AutorService autorService;
@Autowired
LibroService libroService;

@Autowired
GeneroService generoService;

@Autowired
EditorialService editorialService;
	
	@RequestMapping(value="/")
	public String index(Model model)
	{
		model.addAttribute("libros", libroService.listado());
		model.addAttribute("generos", generoService.listado());
		model.addAttribute("editoriales", editorialService.listado());
		
	return "index";
	}
	
	
	
	@RequestMapping(value="/libro/{id}")
	public String libro(Model model, @PathVariable int id)
	{
		Libro objLibros= libroService.buscarPorID(id);
		model.addAttribute("libros",objLibros);
		model.addAttribute("autores",autorService.listado());
		model.addAttribute("generos", generoService.listado());
		model.addAttribute("editoriales", editorialService.listado());
		
		return "libroDetalle";
	}
	
	
	
	@RequestMapping(value="/genero/{id}")
	public String genero(Model model, @PathVariable int id)
	{
		List<Libro> libros= libroService.buscarPorGenero(id);
		model.addAttribute("libros",libros);
		
		model.addAttribute("generos", generoService.listado());
		model.addAttribute("editoriales", editorialService.listado());
		
		return "librosGenero";
	}
	@RequestMapping(value="/editorial/{id}")
	public String editorial(Model model, @PathVariable int id)
	{
		List<Libro> editoriales= libroService.buscarPorGenero(id);
		model.addAttribute("editoriales",editoriales);
		
		model.addAttribute("generos", generoService.listado());
		model.addAttribute("editoriales", editorialService.listado());
		
		
		return "librosEditorial";
	}
	
	
}
