package br.com.rabelonms.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActionsTeclado {
    static WebDriver driver;
    public static void main(String[] args){
        testTecladoAction();
    }
    public static void testTecladoAction(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        WebElement elementEmail = driver.findElement(By.id("email"));
        WebElement elementPass = driver.findElement(By.id("pass"));

        Actions actions = new Actions(driver);
        //sendKeys
        actions.sendKeys(elementEmail, "nicolas@test.com").build().perform();
        actions.sendKeys(elementPass, "123456").build().perform();

        driver.navigate().to("https://www.facebook.com/r.php?locale=pt_BR");
        WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement lastName = driver.findElement(By.name("lastname"));
        //keyDown
        actions.keyDown(firstName, Keys.SHIFT).build().perform();
        actions.sendKeys(firstName, "Nicolas").build().perform();
        //keyUp
        actions.keyUp(lastName, Keys.SHIFT).build().perform();
        actions.sendKeys(lastName, "Rabelo").build().perform();

        driver.close();
    }
}
