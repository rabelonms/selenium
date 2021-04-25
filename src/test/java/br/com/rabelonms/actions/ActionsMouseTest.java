package br.com.rabelonms.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMouseTest {
    static WebDriver driver;
    public static void main(String[] args) {
        testClickAndHoldAction();
    }
    public static void testMouseAction(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        Actions actions = new Actions(driver);
        WebElement inputUsername = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement inputPassword = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        actions.sendKeys(inputUsername,"tomsmith111").build().perform(); //login errado
        actions.doubleClick(inputUsername).build().perform(); //double click p/ selecionar
        inputUsername.clear(); //teoricamente isso não seria necessário!!!
        actions.sendKeys(inputUsername, "tomsmith").build().perform(); //login correto
        actions.sendKeys(inputPassword,"SuperSecretPassword!").build().perform();
        actions.click(loginButton).build().perform();

        driver.close();
    }
    public static void testContextClickAction() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.cssSelector("span.context-menu-one"));

        actions.contextClick(button).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        driver.close();
    }

    public static void testClickAndHoldAction(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        Actions actions = new Actions(driver);

        WebElement inputUsername = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement inputPassword = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        actions.sendKeys(inputUsername, "tomsmith").build().perform();
        actions.sendKeys(inputPassword,"SuperSecretPassword!").build().perform();
        actions.clickAndHold(loginButton).build().perform();
    }
}
