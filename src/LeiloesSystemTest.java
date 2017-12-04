import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {

	    private WebDriver driver;
	    private LeiloesPage leiloes;
	    private UsuariosPage usuarios;

	    @Before
	    public void inicializa() {
	    	System.setProperty("webdriver.firefox.marionette", "C:\\Users\\12129\\OneDrive - Underwriters Laboratories\\11.Test Automation\\Selinium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	    	// System.setProperty("webdriver.gecko.driver", "C:\\Users\\afilipem\\Documents\\Instaladores\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			// Criar novo usuário para o teste
			usuarios = new UsuariosPage(driver);
			usuarios.visita();
			usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
			
	        leiloes = new LeiloesPage(driver); 
	        driver.get("http://localhost:8080/apenas-teste/limpa");
	    }

	    @Test
	    public void deveCadastrarUmLeilao() {

	        leiloes.visita();
	        NovoLeilaoPage novoLeilao = leiloes.novo();
	        novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

	        assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));

	    }
	}
