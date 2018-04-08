package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MePage extends BasePage{

    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickMoreDataAboutYou(){
        WebDriverWait wait = new WebDriverWait(navegador, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MORE DATA ABOUT YOU"))).click();
        //navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }

    public AddContactPage clickAddMoreDataAboutYou(){

        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
        return new AddContactPage(navegador);
    }

}
