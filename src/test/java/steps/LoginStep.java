package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CadastroPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginStep {
    WebDriver driver;
    CadastroPage cadastroPage;
    LoginPage loginPage;

    @Before
    public void before (){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        cadastroPage = new CadastroPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Dado("que esteja na pagina de login: {string}")
    public void queEstejaNaPaginaDeLogin(String url) {
        driver.get(url);
    }

    @Dado("possuo cadastro")
    public void possuoCadastro() throws InterruptedException {
        cadastroPage.clicarRegistrar();
        cadastroPage.preencherEmail("teste@teste.com.br");
        cadastroPage.preencherNome("Fe Fonseca");
        cadastroPage.preencherSenha("teste");
        cadastroPage.preencherConfirmacaoSenha("teste");
        cadastroPage.clicarCriarComSaldo();
        cadastroPage.clicarCadastrar();
        cadastroPage.fecharCadastroComSucesso();
    }

    @Quando("preencher email {string} e senha {string}")
    public void preencherEmailESenha(String email, String senha) {
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
    }

    @E("clicar em fazer login")
    public void clicarEmFazerLogin() {
        loginPage.clicarAcessar();
    }

    @Entao("valido que a pagina de boas vindas foi carregado")
    public void validoQueAPaginaDeBoasVindasFoiCarregado() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }
    @After
    public void after () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
