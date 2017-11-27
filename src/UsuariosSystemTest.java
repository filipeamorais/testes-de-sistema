import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	
	private FirefoxDriver driver;
	private UsuariosPage usuarios;
	
	@Before
	public void inicializa() {
		// por ser uma nova versão preciso setar o webdrive
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\afilipem\\Documents\\Instaladores\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		this.usuarios = new UsuariosPage(driver);
	}

	@After
	public void termina() {
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		/* Nova Implentação 26/11/17
		// Outra implementacao antiga
		FirefoxDriver driver;
		
		// por ser uma nova versão preciso setar o webdrive
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\afilipem\\Documents\\Instaladores\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Outra implementacao antiga
		
		// acessa o site do google
		driver.get("http://localhost:8080/usuarios/new");
		
		// encontrando ambos elementos na pagina
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));
		
		// digitando em cada um deles
		nome.sendKeys("Ronaldo Luiz de Albuquerque");
		email.sendKeys("ronaldo2009@terra.com.br");
		
		// salvando as inclusoes
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		// nome.submit();
		// email.submit(); daria no mesmo!
		
		boolean achouNome = driver.getPageSource().contains("Ronaldo Luiz de Albuquerque");
		boolean achouEmail = driver.getPageSource().contains("ronaldo2009@terra.com.br");
		
		// Função JUnit para verificação
		assertTrue(achouNome);
		assertTrue(achouEmail);
		
		//driver.close();
		Nova Implentação 26/11/17*/
		usuarios.visita();
		usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
		assertTrue (usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
	}
	
	@Test
	public void naoDeveAdicionarUmUsuarioSemNome() {
		/*FirefoxDriver driver;
		
		// por ser uma nova versão preciso setar o webdrive
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\afilipem\\Documents\\Instaladores\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// acessa o site do google
		driver.get("http://localhost:8080/usuarios/new");
		
		// encontrando ambos elementos na pagina
		//WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));
		
		// digitando em cada um deles
		email.sendKeys("ronaldo2009@terra.com.br");
		//email.submit();
		// salvando as inclusoes
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		// Função JUnit para verificação
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
		
		//driver.close();
		Nova implementação 26/11/17*/
		usuarios.visita();
		NovoUsuarioPage form = usuarios.novo();
		form.cadastra("", "ronaldo2009@terra.com.br");
		assertTrue(form.validacaoDeNomeObrigatorio());
	}

	@Test
	public void naoDeveAdicionarSemNomeEEmail() {
		/*FirefoxDriver driver;
		
		// por ser uma nova versão preciso setar o webdrive
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\afilipem\\Documents\\Instaladores\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		*/
		// acessa o site do google
		driver.get("http://localhost:8080/usuarios/new");
		
		// encontrando ambos elementos na pagina
		//WebElement nome = driver.findElement(By.name("usuario.nome"));
		//WebElement email = driver.findElement(By.name("usuario.email"));
		
		// digitando em cada um deles
		//email.sendKeys("ronaldo2009@terra.com.br");
		
		// salvando as inclusoes
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		// Função JUnit para verificação
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
		assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));
		
		//driver.close();
	}
	
	@Test
	public void clicarEmNovoUsuario() {
		
		// acessa o site do sistema
		driver.get("http://localhost:8080/usuarios");
		
		// encontrando ambos elementos na pagina
		WebElement novoUsuario = driver.findElement(By.linkText("Novo Usuário"));
		novoUsuario.click();
		
		// Função JUnit para verificação
		assertTrue(driver.getPageSource().contains("Nome:"));
	}
	
	@Test
	public void excluirUmUsuario() {
		// adicionando um usuario qualquer
		
		usuarios.visita();
		usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque1", "ronaldo2009@terra.com.br1");
		usuarios.deletaUsuarioNaPosicao(1);
		
		assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque1", "ronaldo2009@terra.com.br1"));
	}
}
