package br.com.rabelonms.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestLocator {

    static WebDriver driver;
    public static void main(String[] args){
        testLinkText();
    }
    public static void testIdAndNameLocators(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://facebook.com");
        driver.findElement(By.id("email")).sendKeys("nicolas@test.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        //driver.findElement(By.name("login")).click();
        driver.navigate().to("https://www.facebook.com/r.php?locale=pt_BR");
        driver.findElement(By.name("firstname")).sendKeys("Nicolas");
        driver.findElement(By.name("lastname")).sendKeys("Rabelo");
        driver.findElement(By.name("reg_email__")).sendKeys("nicolas@test.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("nicolas@test.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456");

        driver.close();
    }
    public static void testTagLocator() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?locale=pt_BR");
        List<WebElement> allLinks = driver.findElements(By.tagName("a")); //findElements trás diversos
        System.out.println("quantidade de links encontrados: " + allLinks.size());
        for (WebElement webElement: allLinks) {
            System.out.println(webElement.getText());
        }
        List<WebElement> allLabels = driver.findElements(By.tagName("label")); //findElements trás diversos
        System.out.println("quantidade de labels encontrados: " + allLabels.size());
        for (WebElement webElement: allLabels) {
            System.out.println(webElement.getText());
        }
        driver.close();
    }
    public static void testClassLocator() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://trivago.com.br");
        driver.findElement(By.className("siteheader__control")).click();
        driver.close();
    }
    public static void testLinkText(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        //driver.findElement(By.linkText("Esqueceu a senha?")).click();
        driver.findElement(By.partialLinkText("a senha?")).click();
    }
}
