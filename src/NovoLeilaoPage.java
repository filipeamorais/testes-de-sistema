import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoLeilaoPage {
	
	private WebDriver driver;
	
	public NovoLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void preenche (String nome, double valor, String usuario, boolean usado) {
	WebElement nome1 = driver.findElement(By.name("leilao.nome"));
	WebElement valor1 = driver.findElement(By.name("leilao.valorInicial"));
	
	nome1.sendKeys(nome);
	valor1.sendKeys(String.valueOf(valor));
	
	WebElement combo = driver.findElement(By.name("leilao.usuario.id"));
    Select cbUsuario = new Select(combo);
    cbUsuario.selectByVisibleText(usuario);

    if(usado) {
        WebElement ckUsado = driver.findElement(By.name("leilao.usado"));
        ckUsado.click();
    }

    nome1.submit();
	
	}
	
	public boolean validacaoDeProdutoApareceu() {
        return driver.getPageSource().contains("Nome obrigatorio!");
    }

    public boolean validacaoDeValorApareceu() {
        return driver.getPageSource()
                .contains("Valor inicial deve ser maior que zero!");
    }
	
	
}
