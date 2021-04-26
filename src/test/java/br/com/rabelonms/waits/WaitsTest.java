package br.com.rabelonms.waits;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitsTest {
    static WebDriver driver;

    public static void main(String[] args){
        testWaitExplicito();
    }

    public static void testWaitImplicito(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        //driver.manage().window().maximize();
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.xpath("//button")).click();

        //Pegar atributos do elemento h4
        WebElement textoHelloWorld = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        //Imprimir atributo innerText do h4
        System.out.println(textoHelloWorld.getAttribute("innerText"));
    }

    public static void testWaitExplicito(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.xpath("//button")).click();

        WebElement textoHelloWorld = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='finish']/h4")));

        textoHelloWorld.click();
        System.out.println(textoHelloWorld.getAttribute("innerText"));
    }
}
