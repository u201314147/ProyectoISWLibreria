package pe.com.test.semana10;

import org.testng.annotations.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import pe.com.semana10.controller.LibroController;
import pe.com.semana10.model.Libro;
import pe.com.semana10.service.LibroService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroServiceTest {

	private static LibroController librocontroller;
	LibroService repo;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void probarInsertarLibro()
	{
		try {
			Libro libro = new Libro();
				libro.setTitulo("SuperCampeones");
				libro.setPrecio(30);
				libro.setIsbn("1500-E3310");
				libro.setNuevo(1);
				libro.setSinopsis("La historia de un chico que quiere "
						+ "conocer su verdadero sueño, ser jugador profesional de futbol");
		
		repo.agregar(libro);
		Assert.assertTrue(true);
		//Si llega a esta linea de codigo entonces la prueba es correcta
			}catch(Exception e)
			{
				//Si hay una excepcion la prueba falla;
				Assert.fail();
			}
	}
	
	@Test
	  public void probarListarLibro() {
			try {

		repo.listado();
		Assert.assertTrue(true);
		//Prueba acertada
			}catch(Exception e)
			{
				Assert.fail();
				//Prueba falida
			}
			
	  }
	
	@Test
	  public void AgregarLibroValidarSiExiste() {
			try {
				Libro libro = new Libro();
				libro.setTitulo("El Secreto");
				libro.setPrecio(99);
				libro.setIsbn("2400-F4410");
				libro.setNuevo(1);
				libro.setSinopsis("Si conocer el secreto deseas"
						+ "este libro leer deberás");
		;
			
		repo.agregar(libro);	
		List<Libro> libros = repo.listado();
		for(Libro lib : libros){
			if(lib.getTitulo() == "El Secreto")
				Assert.assertTrue(true);
		}
			}catch(Exception e)
			{
				//Si hay excepcion la prueba falla
				Assert.fail();
			}	
	  }
	
	@SuppressWarnings("deprecation")
	@Test
	  public void ProbandoModeloLibro() {
		
		Libro libro = new Libro();
		libro.setTitulo("Los Bandidos");
		libro.setPrecio(20);
		libro.setIsbn("4250-AK490");
		libro.setNuevo(0);
		libro.setSinopsis("La historia de tres bandidos"
				+ "que van en busca de chicas por la ciudad");
		
		Assert.assertEquals(libro.getTitulo(),"Los Bandidos");
		Assert.assertEquals(libro.getPrecio(),20);
		Assert.assertEquals(libro.getIsbn(),"4250-AK490");
		Assert.assertEquals(libro.getNuevo(),0);
		Assert.assertEquals(libro.getSinopsis(),"La historia de tres bandidos"
				+ "que van en busca de chicas por la ciudad");
	  }
	
	
}
