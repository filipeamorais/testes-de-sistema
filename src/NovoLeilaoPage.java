import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoLeilaoPage {
	
	private WebDriver driver;
	public NovoLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}

	WebElement nome = driver.findElement(By.name("leilao.nome"));
	WebElement valor = driver.findElement(By.name("leilao.valorInicial"));
	
	nome.sendKeys("Dono do Produto");
	valor.sendKeys("123,45");
	
	
}
