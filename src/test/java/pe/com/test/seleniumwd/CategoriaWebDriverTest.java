package pe.com.test.seleniumwd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CategoriaWebDriverTest {

	private WebDriver driver;
	private String urlInicial = "http://localhost:8080/admin/login";
	
	@BeforeTest
	public void setUp() throws Exception {
	//	System.setProperty("webdriver.gecko.driver", "C:\\ProgramasInstalados\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\ProgramasInstalados\\chromedriver.exe");
		
		
	//	driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void insertarCategoria_FlujoBasico() throws Exception {
		try {
			String mensajeEsperado = "Se guardó de manera correcta la Categoría";
			driver.get(urlInicial);
			driver.findElement(By.id("exampleInputEmail1")).clear();
			driver.findElement(By.id("exampleInputEmail1")).sendKeys("usuario@correo.com");
			driver.findElement(By.id("exampleInputPassword1")).clear();
			driver.findElement(By.id("exampleInputPassword1")).sendKeys("456");
			driver.findElement(By.id("btnSubmit")).click();
			
			//...
			/*
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/section/div[1]/div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/section/div[1]/nav/ul/li/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Mnt. de Categoría")).click();;
			Thread.sleep(2000);
			driver.findElement(By.id("btnNuevo")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtNombre")).clear();
			driver.findElement(By.id("txtNombre")).sendKeys("Categoría Prueba");
			driver.findElement(By.id("btnGuardar")).click();
			Thread.sleep(2000);
			String mensajeObtenido = driver.findElement(By.id("messages")).getText();
			Assert.assertEquals(mensajeObtenido, mensajeEsperado);
			Thread.sleep(2000);
			*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"insertarCategoria_FlujoBasico"})
	public void insertarCategoria_FlujoAlternativo() throws Exception {
		try {
			/*String mensajeEsperado = "Nombre: Error de validación: se necesita un valor.";
			driver.get(urlInicial);
			driver.findElement(By.id("txtUsuario")).clear();
			driver.findElement(By.id("txtUsuario")).sendKeys("admin");
			driver.findElement(By.id("txtClave")).clear();
			driver.findElement(By.id("txtClave")).sendKeys("clave");
			driver.findElement(By.id("btnIniciarSesion")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/section/div[1]/div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/section/div[1]/nav/ul/li/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Mnt. de Categoría")).click();;
			Thread.sleep(2000);
			driver.findElement(By.id("btnNuevo")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtNombre")).clear();
			driver.findElement(By.id("txtNombre")).sendKeys("");
			driver.findElement(By.id("btnGuardar")).click();
			Thread.sleep(2000);
			String mensajeObtenido = driver.findElement(By.id("messages")).getText();
			Assert.assertEquals(mensajeObtenido, mensajeEsperado);
			Thread.sleep(2000);*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}
}
