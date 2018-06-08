package pe.com.semana10.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Libro;
import pe.com.semana10.repositorio.AutorRepositorio;
import pe.com.semana10.service.AutorService;
import pe.com.semana10.service.AutorServiceImpl;

@Controller
public class AutorController {
	@Autowired
	AutorService autorService;
	
	@RequestMapping(value="/admin/autor/listado")
	public String listado(Model model ){
		
		List<Autor> autores = autorService.listado();		
		model.addAttribute("autor", new Autor());
		
		model.addAttribute("listadoAutores", autores);
		
		return "admin/autor_listado";
	}
	
	@RequestMapping(value="/admin/autor/buscarPorNombre")
	public String busquedaPorNombre(@ModelAttribute Autor objAutor, Model model){
		model.addAttribute("listadoAutores", autorService.buscarPorNombre(objAutor.getNombres()));
		return "admin/autor_listado";
	}
	
	@RequestMapping(value="/admin/autor/nuevo")
	public String nuevo(Model model){
		Autor objAutor = new Autor();
		model.addAttribute("autor", objAutor);
		
		return "admin/autor_nuevo";
	}
	
	@RequestMapping(value="/admin/autor/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Autor objAutor, 
									BindingResult binRes, 
									Model model,
									RedirectAttributes redirAtt){
		if (binRes.hasErrors()){
			//return "redirect:/admin/autor/nuevo";
			return "admin/autor_nuevo";
		}else{
			boolean flag = autorService.agregar(objAutor);
			if(flag){
				
				
				redirAtt.addFlashAttribute("mensaje", "Autor agregado correctamente");
				
				
				return "redirect:/admin/autor/listado";
				//return "autor_listado";
			}else{
				model.addAttribute("mensaje", "Ocurrió un error");
				//redirAtt.addFlashAttribute("mensaje", "Ocurrió un error");
				//return "redirect:/admin/autor/nuevo";
				return "admin/autor_nuevo";
			}
		}
	}
	
	@RequestMapping(value="/admin/autor/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model, RedirectAttributes objRedir){
		boolean flag;
		flag = autorService.eliminar(id);
		if(flag){
			//model.addAttribute("mensaje", "Autor eliminado");
			objRedir.addFlashAttribute("mensaje", "Autor eliminado");
			return "redirect:/admin/autor/listado";
		}else{
			//model.addAttribute("mensaje", "Ocurrió un error");
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/admin/autor/listado";
		}
	}
	
	@RequestMapping(value="/admin/autor/editar/{id}")
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir){
		Autor objAutor = autorService.buscarPorId(id);
		if(objAutor == null){
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/admin/autor/listado";
		}else{
			model.addAttribute("autor", objAutor);
			return "admin/autor_editar";
		}
	}
	
	@RequestMapping(value="/admin/autor/actualizar", method=RequestMethod.POST)
	public String actualizar(@ModelAttribute Autor objAutor, Model model, RedirectAttributes objRedir){
		boolean flag = autorService.actualizar(objAutor);
		
		if(flag){
			objRedir.addFlashAttribute("mensaje", "Autor actualizado");
			return "redirect:/admin/autor/listado";
			//return "autor_listado";
		}else{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/admin/autor/listado";
		}
	}
}
