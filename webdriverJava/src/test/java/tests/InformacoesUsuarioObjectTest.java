package tests;

import Pages.LoginPage;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import java.net.MalformedURLException;

public class InformacoesUsuarioObjectTest {

    private WebDriver navegador;

    private String screenShotLocation = "/Users/renanchagas/Documents/Workspace-UDEMY/Testes com Selenium WebDriver em Java/Screenshots/";

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws MalformedURLException {
        navegador = Web.createBrowserStack();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        String toastText = new LoginPage(navegador)
            .signIn()
            .login("julio0001", "123456")
            .clickMe()
            .clickMoreDataAboutYou()
            .clickAddMoreDataAboutYou()
            .addContact("Phone","+451133334444")
            .captureToastText();

        Assert.assertEquals("Your contact has been added!", toastText);

        String screenshot =
                screenShotLocation
                        + Generator.dataHoraArquivo()
                        + testName.getMethodName()
                        + ".png";

        Screenshot.TirarScreenshot(navegador,screenshot);
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
