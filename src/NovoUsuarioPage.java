
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class NovoUsuarioPage {

	private WebDriver driver;
	
	public NovoUsuarioPage (WebDriver driver) {
		this.driver = driver;
	}
		
	public void cadastra (String nome, String email) {
		WebElement txtNome = driver.findElement (By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement (By.name("usuario.email"));
		
		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);
		
		driver.findElement(By.id("btnSalvar")).click();
	}
	
	public boolean validacaoDeNomeObrigatorio () {
		return driver.getPageSource().contains("Nome obrigatorio!");
	}
	
}
