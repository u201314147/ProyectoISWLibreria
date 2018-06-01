package pe.com.semana10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.semana10.model.Administrador;
import pe.com.semana10.model.Rol;
import pe.com.semana10.repositorio.AdministradorRepositorio;
import pe.com.semana10.service.AdministradorService;

@Controller
public class AdminController {
	
	@Autowired
	PasswordEncoder passEncoder;
	@Autowired
	AdministradorService adminService;
	
	@RequestMapping(value={"/admin","/admin/", "/admin/login"})
	public String login(Model model){
		Administrador admin = new Administrador();
		model.addAttribute("admin", admin);
		
		/****/
		/*admin.setNombres("Usuario02");
		admin.setApellidos("Apellidos02");
		admin.setCorreo("correo2@correo.com");
		
		Rol objRol = new Rol();
		objRol.setId(1);
		admin.setRol(objRol);
		
		admin.setClave(passEncoder.encode("456"));
		
		adminService.guardar(admin);*/
		/***/
		
		return "admin/login";
	}
	
	@RequestMapping(value={"/admin/denied"})
	public String denied(){
		
		return "admin/denied";
	}
	
	@RequestMapping(value={"/admin/logout"})
	public String logout(){
		
		return "admin/login";
	}
	
	@RequestMapping(value="/admin/dashboard")
	public String dashboard(){
		
		return "admin/dashboard";
	}
}
