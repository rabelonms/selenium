package br.com.rabelonms.comandos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ComandosNavegacaoTest {

    static WebDriver driver;
    public static void main(String[] args){
        navegacao();

    }
    public static void navegacao(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.navigate().to("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Celular");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.linkText("Shopping")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
    }
}
