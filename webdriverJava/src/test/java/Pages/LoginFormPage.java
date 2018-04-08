package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {

    private WebDriver navegador;

    public LoginFormPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginFormPage typeLogin(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public LoginFormPage typePassword(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public HomePage clickSignIn(){
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new HomePage(navegador);
    }

    public HomePage login(String login, String password){
        typeLogin(login);
        typePassword(password);
        clickSignIn();

        return new HomePage(navegador);
    }
}
