package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PageBase {

    protected WebDriver webDriver;


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/Resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }


    @AfterMethod
    public void closeDown(){
        webDriver.close();
    }

    public void Sleep(Integer segundos){
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
        }
    }


}