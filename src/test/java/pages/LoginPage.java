package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    WebDriver driver;

    String EMAIL = "//*[@id='__next']/div/div[2]/div/div[1]/form/div[1]/input";
    String SENHA = "//*[@id='__next']/div/div[2]/div/div[1]/form/div[2]/div/input";
    String ACESSAR = "//button[contains(text(),'Acessar')]";
    String FECHARERRODELOGIN = "//a[@id='btnCloseModal']";

    public LoginPage (WebDriver driverLogin){
        this.driver = driverLogin;
    }

    public void preencherEmail(String email){
        driver.findElement(By.xpath(EMAIL)).sendKeys(email);
    }

    public void preencherSenha (String senha){
        driver.findElement(By.xpath(SENHA)).sendKeys(senha);
    }

    public void clicarAcessar (){
        driver.findElement(By.xpath(ACESSAR)).click();
    }

    public void fecharMensagemErro () throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath(FECHARERRODELOGIN)).click();
    }
}
