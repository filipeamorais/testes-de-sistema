import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlteraUsuarioPage {

	private WebDriver driver;
	
	public AlteraUsuarioPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public UsuariosPage para(String nome, String email) {
        WebElement txtNome = driver.findElement(By.name("usuario.nome"));
        WebElement txtEmail = driver.findElement(By.name("usuario.email"));

            txtNome.clear();
            txtEmail.clear();

        txtNome.sendKeys(nome);
        txtEmail.sendKeys(email);

        // txtNome.submit(); Não funciona, tem que ser o botão salvar
        driver.findElement(By.id("btnSalvar")).click();
        return new UsuariosPage(driver);
    }
	
	
}
