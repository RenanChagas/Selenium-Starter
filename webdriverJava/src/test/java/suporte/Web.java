package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class Web {

    public static final String USERNAME = "renanchagas1";
    public static final String AUTOMATE_KEY = "P4CqwAnRpHdZFy66BnS3";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver CreateChrome(){

        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","/Users/renanchagas/Documents/Workspace-UDEMY/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a pagina do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }

    public static WebDriver createBrowserStack() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "65.0");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "High Sierra");
        caps.setCapability("resolution", "1600x1200");

        WebDriver driver = null;

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Navegando para a pagina do Taskit
            driver.get("http://www.juliodelima.com.br/taskit");
        }
        catch (MalformedURLException e) {
            System.out.print("URL Problem: " + e.getMessage());
        }

        return driver;
    }

}
