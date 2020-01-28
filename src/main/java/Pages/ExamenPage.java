package Pages;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ExamenPage extends PageBase {

    private WebElement IMG_LOGO() {return webDriver.findElement(By.xpath("//a[@class='nav-logo']"));}
    private WebElement BTN_CATEGORIAS() {return webDriver.findElement(By.xpath("//a[@class='nav-menu-categories-link']"));}
    private WebElement LBL_CAT(String c) {return webDriver.findElement(By.xpath("*//li/a[contains(text(),'"+c+"')]"));}
    private WebElement LBL_SUB(String s) {return webDriver.findElement(By.xpath("*//ul//a[contains(text(),'"+s+"')]"));}
    private WebElement LBL_TITULOSUB() {return webDriver.findElement(By.xpath("//h1[@class='breadcrumb__title']"));}
    private WebElement LBL_CANTRESULTADO() {return webDriver.findElement(By.xpath("//*[@id='inner-main']/aside/div[2]"));}
    private WebElement RES_GRILLA(Integer i) {return webDriver.findElement(By.xpath("//*[@id='searchResults']/li["+i+"]"));}
    private WebElement LBL_UBICACION(String ub) {return webDriver.findElement(By.xpath("(//a[contains(@title,'"+ub+"')])[1]"));}
    private WebElement LBL_TITULOREULTADO(Integer i) {return webDriver.findElement(By.xpath("(*//span[contains(@class,'main-title')])["+i+"]"));}
    private WebElement LBL_VALORREULTADO(Integer i) {return webDriver.findElement(By.xpath("(*//span[contains(@class,'price__fraction')])["+i+"]"));}
    private WebElement LBL_TITULOPUBLICACION() {return webDriver.findElement(By.xpath("//div[@class='ui-pdp-container__top-wrapper mt-40']//h1[@class='ui-pdp-title']"));}
    private WebElement LBL_TITULOPUBLICACION2() {return webDriver.findElement(By.xpath("//h1[contains(@class,'item-title__primary')]"));}
    private WebElement LBL_VALORPUBLICACION() {return webDriver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[1]/span[1]/span[2]"));}
    private WebElement LBL_VALORPUBLICACION2() {return webDriver.findElement(By.xpath("//*[@id='productInfo']/fieldset[1]/span[contains(@class,'price-tag')]/span[contains(@class,'price-tag-fraction')]"));}


    public void AbrirWeb() {
        System.setProperty("webdriver.chrome.driver","src/main/Resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://www.mercadolibre.com.ar");
        webDriver.manage().window().maximize();
    }

    public void ValidarIngreso() {
        IMG_LOGO().isDisplayed();
    }


    public int CantidadDeResultados(){
        List<WebElement> elements = webDriver.findElements(By.cssSelector("#searchResults > li"));
        return elements.size();
    }


    public void IngresarSubcategoria(String categoria, String sub) {
        Sleep(2);
        BTN_CATEGORIAS().click();
        try {
            LBL_CAT(categoria).click();
            Sleep(1);
            LBL_SUB(sub).click();
        } catch (Exception e){
            System.out.println("La categoria no existe");
            System.out.println(e);
        }
        Sleep(2);
    }

    public void ValidarSubYCantidad(String sub) {
        Assert.assertTrue(LBL_TITULOSUB().getText().equals(sub), "El nombre mostrado es incorrecto");
        LBL_CANTRESULTADO().isDisplayed();
        System.out.println("LA CANTIDAD DE RESULTADOS ES: " + LBL_CANTRESULTADO().getText());
    }


    public void FiltrarUbicacion(String ubicacion) {
        LBL_UBICACION(ubicacion).click();
        Sleep(2);
    }

    public void VerificarDatosPublicacion() {
        int valor = (int) (Math.random() * CantidadDeResultados()) + 1;
        String Titulo_Resultado = LBL_TITULOREULTADO(valor).getText();
        String Valor_Resultado = LBL_VALORREULTADO(valor).getText();
        LBL_TITULOREULTADO(valor).click();
        Sleep(2);
        try {
            Assert.assertTrue(LBL_TITULOPUBLICACION2().getText().equals(Titulo_Resultado),"El titulo no es el mismo");
        } catch (Exception e) {
            Assert.assertTrue(LBL_TITULOPUBLICACION().getText().equals(Titulo_Resultado),"El titulo no es el mismo");
        }
        try {
            Assert.assertTrue(LBL_VALORPUBLICACION2().getText().equals(Valor_Resultado),"El valor no es el mismo");
        } catch (Exception e) {
            Assert.assertTrue(LBL_VALORPUBLICACION().getText().equals(Valor_Resultado),"El valor no es el mismo");
        }

        System.out.println("EL PRODUCTO ES: "+Titulo_Resultado);
        System.out.println("EL VALOR ES: "+Valor_Resultado);

    }

    public void CerrarDriver(){
        closeDown();
    }
}
