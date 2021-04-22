package br.com.rabelonms.comandos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestComandoWebElement {

    static WebDriver driver;
    public static void main(String[] args){
        webElement();
    }
    public static void webElement(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");
        driver.findElement(By.id("email")).sendKeys("nicolas@test.com");
        driver.findElement(By.id("email")).clear();
        boolean apareceu = driver.findElement(By.id("email")).isDisplayed();
        System.out.println(apareceu);
        boolean habilitado = driver.findElement(By.id("email")).isEnabled();
        System.out.println(habilitado);
        String texto = driver.findElement(By.linkText("Esqueceu a senha?")).getText();
        System.out.println(texto);
        driver.findElement(By.name("login")).submit();
        driver.close();
    }
}
