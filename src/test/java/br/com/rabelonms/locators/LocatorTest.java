package br.com.rabelonms.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorTest {

    static WebDriver driver;
    public static void main(String[] args){
        testCssSelectorSubstringLocator();
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
        driver.close();
    }
    public static void testCssSelectorByIdLocator(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?locale=pt_BR");
        driver.findElement(By.cssSelector("label#menu_login_sho w_link")).click(); //ou o de baixo
        //driver.findElement(By.cssSelector("label[id='menu_login_show_link']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("nicolas@test.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("label#loginbutton")).click();
        driver.close();
    }
    public static void testCssSelectorByClassLocator(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?locale=pt_BR");
        driver.findElement(By.cssSelector("label.menu_login_show_link")).click();
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("nicolas@test.com"); //not by class
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123456"); //not by class
        driver.findElement(By.cssSelector("label.login_form_login_button")).click();
        driver.close();
    }
    public static void testCssSelectorByAttributeLocator(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?locale=pt_BR");
        driver.findElement(By.cssSelector("label[id='menu_login_show_link']")).click();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("nicolas@test.com");
        driver.findElement(By.cssSelector("input[data-testid='royal_pass']")).sendKeys("123456");
        driver.findElement(By.cssSelector("label[id='loginbutton']")).click();
        driver.close();
    }
    public static void testCssSelectorSubstringLocator(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?locale=pt_BR");

        driver.findElement(By.cssSelector("input[name^='first']")).sendKeys("nicolas"); //prefixo
        driver.findElement(By.cssSelector("input[name$='astname']")).sendKeys("rabelo"); //sufixo
        driver.findElement(By.cssSelector("input[name*='email__']")).sendKeys("nicolas@test.com");
        driver.close();
    }
}