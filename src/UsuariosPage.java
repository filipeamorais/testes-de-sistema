import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class UsuariosPage{
	
	private WebDriver driver;
	
	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
		driver.get("http://localhost:8080/usuarios");
	}
	
	public NovoUsuarioPage novo() {
		// clica no link de novo usuario
		driver.findElement(By.linkText("Novo Usu�rio")).click();
		// retorna a classe que representa a nova pagina
		return new NovoUsuarioPage (driver);
	}
	
	public boolean existeNaListagem (String nome, String email) {
		// verifica se amabos existem na listagem
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email); 
	}
	
	public void deletaUsuarioNaPosicao(int posicao) {
		driver.findElements(By.tagName("button")).get(posicao-1).click();
		
		// pega o alert do JavaScript que est� aberto
		Alert alert = driver.switchTo().alert();
		
		// confirma o JavaScript
		alert.accept();
	}
	
	public AlteraUsuarioPage altera (int posicao) {
		driver.findElements(By.linkText("editar")).get(posicao-1).click();		
		return new AlteraUsuarioPage (driver);
	}
}
