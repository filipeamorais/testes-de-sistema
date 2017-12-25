import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {

	 private WebDriver driver;
	 private LeiloesPage leiloes;
	 //private CriadorDeCenarios cenarios;
	 //private DetalhesDoLeilaoPage leiloes_2;
	 
	 @Before
	 public void inicializa () {
		 // por ser uma nova versão preciso setar o webdrive
		 //System.setProperty("webdriver.firefox.marionette", "C:\\Users\\12129\\OneDrive - Underwriters Laboratories\\11.Test Automation\\Selinium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\afilipem\\Documents\\Instaladores\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		 //System.setProperty("webdriver.firefox.marionette", "C:\\Users\\afilipem\\Documents\\Instaladores\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();

         driver.get("http://localhost:8080/apenas-teste/limpa");

         //CriadorDeCenarios cenarios = new CriadorDeCenarios (driver);
         /*
		 UsuariosPage usuarios = new UsuariosPage(driver);
		 usuarios.visita();
		 usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
		 usuarios.novo().cadastra("José Alberto", "jose@alberto.com");
          */
         
         new CriadorDeCenarios(driver)
         .umUsuario("Paulo Henrique", "paulo@henrique.com")
         .umUsuario("José Alberto", "jose@alberto.com")
         .umLeilao("Paulo Henrique", "Geladeira", 100, false);
         
         /*
		 leiloes = new LeiloesPage(driver);
		 leiloes.visita();
		 leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
		 */
	 	}	
	 
	 @Test
	 public void deveFazerUmLance() {
		 	leiloes = new LeiloesPage(driver);
	        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

	        lances.lance("José Alberto", 150);

	        assertTrue(lances.existeLance("José Alberto", 150));
	    }
	 }
