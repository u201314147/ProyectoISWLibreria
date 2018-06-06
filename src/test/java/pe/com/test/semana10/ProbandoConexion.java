package pe.com.test.semana10;

import java.util.List;

import bsh.Console;
import pe.com.semana10.model.Autor;
import pe.com.semana10.service.AutorServiceImpl;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProbandoConexion {

	 public static void main(String[] args)
	 {
		
		 AutorServiceImpl repo = new AutorServiceImpl();
		 
		 //repo.listado().stream().forEach(r -> System.out.println(r.getNombres()));

		 System.out.println("Empezando listado");
		 List<Autor> autores = repo.listado();
		 System.out.println("Empezando recorrido");
		 for(Autor a: autores) {
			 System.out.println(a.getNombres());
		 }
		 System.out.println("Fin listado");
	 }
		
}
