package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InformacoesUsuarioTest {

    private WebDriver navegador;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(){

        navegador = Web.CreateChrome();

        // Clicar no link que possui o texto "Sign in"
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        //Identificando o formulario de Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo com name "login" que está dentro do formulario de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com name "password" que está dentro do formulario de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Clicar em um link que possui a class "me"
        WebElement me = navegador.findElement(By.className("me"));
        me.click();

        // Clicar no link com o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Test
    public void test1AdicionarUmaInformacaoAdicionalDoUsuario(){

        // Clicar no botao através do seu xpath //button[@data-target='addmoredata']
        // XPATH - ctrl + f no inspect = //div[@id='moredata]
        // OU XPATH - //div[@div='moredata']//button[@data-target='addmoredata']
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulário de id "addmoredata"
        WebElement popup = navegador.findElement(By.id("addmoredata"));

        // Na combo de name "type" escolher a opção "Phone"
        WebElement campotype = popup.findElement(By.name("type"));
        new Select(campotype).selectByVisibleText("Phone");

        // Digitar no campo com name "contact" +4511999999999
        popup.findElement(By.name("contact")).sendKeys("+451133334444");

        // Clicar no link de text "SAVE" que está na popup
        popup.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é "Your Contact has been added!"
        WebElement toast = navegador.findElement(By.id("toast-container"));
        Assert.assertEquals("Your contact has been added!", toast.getText());

    }

    @Test
    public void test2removerUmContatoDeUmUsuario(){

        //Clicar no seu elemento pelo xpath: //span[text()="+451133334444"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+451133334444\"]/following-sibling::a")).click();

        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem apresentada foi: Rest in peace, dear phone!
        WebElement toast = navegador.findElement(By.id("toast-container"));
        Assert.assertEquals("Rest in peace, dear phone!", toast.getText());


        //Tirar Screenshot
        String screenshot =
                "/Users/renanchagas/Documents/Workspace-UDEMY/Testes com Selenium WebDriver em Java/Screenshots/"
                + Generator.dataHoraArquivo()
                + testName.getMethodName()
                + ".png";

        Screenshot.TirarScreenshot(navegador,screenshot);

        //Aguardar até 10 segudos até que a janela desapareca
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(toast));

        //Clicar no link com o testo: logout
        navegador.findElement(By.linkText("Logout")).click();

    }

    @After
    public void tearDown(){

        // Fechar o navegador
        navegador.close();
    }

}
