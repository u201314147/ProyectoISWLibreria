package pe.com.test.semana10;

import org.testng.annotations.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import pe.com.semana10.controller.AutorController;
import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Genero;
import pe.com.semana10.service.AutorServiceImpl;
import pe.com.semana10.service.GeneroService;
import pe.com.semana10.service.GeneroServiceImpl;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroServiceTest {

	GeneroService repo;
	@Test
	public void contextLoads() {
	}
		
	@Test
	  public void probarListarGeneros() {
			try {

		repo.listado();
		Assert.assertTrue(true);
			}catch(Exception e)
			{
				Assert.fail();
			}	
	  }  
	
	@Test
	  public void ProbandoModeloGenero() {
		
		Genero genero = new Genero();
		genero.setNombre("Fantasia");
		Assert.assertEquals(genero.getNombre(),"Fantasia");
	  }
	
}
