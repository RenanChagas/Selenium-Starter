package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickMe(){
        WebDriverWait wait = new WebDriverWait(navegador, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("me"))).click();
        //navegador.findElement(By.className("me")).click();
        return new MePage(navegador);
    }
}
