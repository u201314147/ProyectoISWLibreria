package pe.com.semana10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.semana10.model.Libro;
import pe.com.semana10.service.AutorService;
import pe.com.semana10.service.EditorialService;
import pe.com.semana10.service.GeneroService;
import pe.com.semana10.service.LibroService;

@Controller
public class LibroController {
	
	@Autowired
	GeneroService generoService;
	@Autowired
	EditorialService editorialService;
	@Autowired
	AutorService autorService;
	@Autowired
	LibroService libroService;
	
	@RequestMapping(value="/admin/libro/nuevo")
	public String nuevo(Model model){
		model.addAttribute("generos", generoService.listado());
		model.addAttribute("editoriales", editorialService.listado());
		model.addAttribute("autores", autorService.listado());
		
		Libro libro = new Libro();
		model.addAttribute("libro", libro);
		
		return "admin/libro_nuevo";
	}
	
	@RequestMapping(value="/admin/libro/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute Libro libro, Model model, RedirectAttributes redirAtt){
		boolean flag = libroService.agregar(libro);
		if(flag){
			redirAtt.addFlashAttribute("mensaje", "Libro agregado");
		}else{
			redirAtt.addFlashAttribute("mensaje", "Ocurrió un error");
		}
		return "redirect:/admin/libro/listado";
	}
	
	@RequestMapping(value="/admin/libro/listado")
	public String listado(Model model){
		model.addAttribute("libro", new Libro());
		model.addAttribute("listadoLibros", libroService.listado());
		
		return "admin/libro_listado";
	}
	
	@RequestMapping(value="/admin/libro/listadoPaginacion")
	public String listadoPaginacion(Model model, Pageable paginacion){
		model.addAttribute("libro", new Libro());
		
		model.addAttribute("listadoLibros", libroService.listadoConPaginacion(paginacion));
		
		System.out.println(paginacion.getPageNumber());
		System.out.println(paginacion.getPageSize());
		System.out.println(paginacion.first());
		System.out.println(paginacion.previousOrFirst());
		
		return "admin/libro_listado";
	}
	
	@RequestMapping(value="/admin/libro/buscarPorPrecio")
	public String busquedaPorPrecio(@ModelAttribute Libro objLibro, Model model){
		model.addAttribute("listadoLibros", libroService.buscarPorPrecio(objLibro.getPrecio()));
		
		
		return "admin/libro_listado";
	}
}
