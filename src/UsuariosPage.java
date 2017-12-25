import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class UsuariosPage{
	
	private WebDriver driver;
	
	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
        driver.get(new URLDaAplicacao().getUrlBase() + "/usuarios");
    }
	
	public NovoUsuarioPage novo() {
		// clica no link de novo usuario
		driver.findElement(By.linkText("Novo Usuário")).click();
		// retorna a classe que representa a nova pagina
		return new NovoUsuarioPage (driver);
	}
	
	public boolean existeNaListagem (String nome, String email) {
		// verifica se amabos existem na listagem
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email); 
	}
	
	public void deletaUsuarioNaPosicao(int posicao) {
		driver.findElements(By.tagName("button")).get(posicao-1).click();
		
		// pega o alert do JavaScript que está aberto
		Alert alert = driver.switchTo().alert();
		
		// confirma o JavaScript
		alert.accept();
		
		// Foi necessario criar esse thread sleep para dar tempo de excluir
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//button[contains(.,'excluir')]")).click();
	}
	
	public AlteraUsuarioPage altera (int posicao) {
		driver.findElements(By.linkText("editar")).get(posicao-1).click();		
		return new AlteraUsuarioPage (driver);
	}
}
