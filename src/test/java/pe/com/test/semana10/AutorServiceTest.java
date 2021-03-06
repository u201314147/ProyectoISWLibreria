package pe.com.test.semana10;

import org.testng.annotations.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import org.junit.BeforeClass;

import pe.com.semana10.model.Autor;
import pe.com.semana10.service.AutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorServiceTest {
	
	@Autowired
	AutorService repo;
	
	@BeforeClass
	public void before() {	
		 System.out.println("Antes de prueba");
	}
	
	@Test
	public void contextLoads() {
		 System.out.println("Context loaded");
	}
	
	@Test
	public void probarInsertarAutor()
	{
		try {
			Autor autor = new Autor();
				autor.setNombres("Juan Francisco");
				autor.setApellidos("Perez Enriques");
				autor.setNacionalidad("Argentino");
		
		repo.agregar(autor);
		Assert.assertTrue(true);
		//Si llega a esta linea de codigo entonces la prueba es correcta
			}catch(Exception e)
			{
				//Si hay una excepcion la prueba falla;
				Assert.fail();
			}
	}
	
	@Test
	  public void probarListarEmpleado() {
			try {

		repo.listado();
		Assert.assertTrue(true);
			}catch(Exception e)
			{
				Assert.fail();
			}
			
	  }
	
	@Test
	  public void eliminarAutorDebeDarError() {
			try {
		repo.eliminar(-1);
		Assert.fail();
			}catch(Exception e)
			{
				//Debe dar excepcion para que la prueba sea correcta
				Assert.assertTrue(true);
			}
			
	  }
	
	
	@Test
	  public void AgregarAutorValidarSiExiste() {
			try {
				Autor autor = new Autor();
				autor.setNombres("Juan Carlos");
			autor.setApellidos("Espinoza Suarez");
			autor.setNacionalidad("Espaniol");
			
		repo.agregar(autor);	
		List<Autor> autores = repo.listado();
		for(Autor aut : autores){
			if(aut.getNombres() == "Juan Carlos")
				Assert.assertTrue(true);
		}
			}catch(Exception e)
			{
				//Si hay excepcion la prueba falla
				Assert.fail();
			}	
	  }
	
	@Test
	  public void ProbandoModeloAutor() {
		
		Autor autor = new Autor();
		
	
		autor.setNombres("Maximo Ali");
		autor.setApellidos("Mallqui Tertuliano");
		autor.setNacionalidad("Peruano");
		
		Assert.assertEquals(autor.getNombres(),"Maximo Ali");
		Assert.assertEquals(autor.getNacionalidad(),"Peruano");
		Assert.assertEquals(autor.getApellidos(),"Mallqui Tertuliano");
	
	  }
	

}
