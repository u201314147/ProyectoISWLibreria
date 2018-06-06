package pe.com.test.semana10;

import org.testng.annotations.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import pe.com.semana10.model.Editorial;
import pe.com.semana10.service.EditorialService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorialServiceTest {

	EditorialService repo;
	@Test
	public void contextLoads() {
	}
		
	@Test
	  public void probarListarEditoriales() {
			try {
		repo.listado();
		Assert.assertTrue(true);
			}catch(Exception e)
			{
				Assert.fail();
			}	
	  }  
	
	@Test
	  public void ProbandoModeloEditorial() {
		
		Editorial editorial = new Editorial();
		editorial.setNombre("Coquito");
		Assert.assertEquals(editorial.getNombre(),"Coquito");
	  }
	
}
