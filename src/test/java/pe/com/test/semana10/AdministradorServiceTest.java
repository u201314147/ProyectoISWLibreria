package pe.com.test.semana10;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.testng.annotations.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import pe.com.semana10.controller.AutorController;
import pe.com.semana10.model.Administrador;
import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Editorial;
import pe.com.semana10.model.Genero;
import pe.com.semana10.model.Rol;
import pe.com.semana10.service.AdministradorService;
import pe.com.semana10.service.AdministradorServiceImpl;
import pe.com.semana10.service.AutorServiceImpl;
import pe.com.semana10.service.EditorialServiceImpl;
import pe.com.semana10.service.GeneroServiceImpl;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradorServiceTest {

	@Autowired
	PasswordEncoder passEncoder;
	
	AdministradorService repo;
	@Test
	public void contextLoads() {
	} 
	
	@Test
	  public void ProbandoModeloAdmistrador() {
		
		try {
		Administrador admin = new Administrador();
		admin.setNombres("Juan Luis");
		admin.setCorreo("juan_prueba@hotmail.com");
		admin.setApellidos("Enrique Elias");
		
		Assert.assertEquals(admin.getNombres(),"Juan Luis");
		Assert.assertEquals(admin.getCorreo(),"juan_prueba@hotmail.com");
		Assert.assertEquals(admin.getApellidos(),"Enrique Elias");
		
		//Creo nuevo rol para el administrador
		Rol objRol = new Rol();
		objRol.setId(1);
		admin.setRol(objRol);
		
		admin.setClave(passEncoder.encode("tuclave123"));
		
		
		
		repo.guardar(admin);
		Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.fail();
		}
	  }
	
}
