package br.com.rabelonms.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocatorTest {
    static WebDriver driver;
    public static void main(String[] args){
        xpathRelativo();

    }
    public static void xpathAbsoluto(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.magazineluiza.com.br/");
        //driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div[1]/header/div/div[1]/div/div/div[2]/div[2]/div/input")).sendKeys("Celular");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div[1]/header/div/div[1]/div/div/div[2]/div[2]/div/span/i")).click();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, 200)");

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[3]/div/div[2]/ul/li[2]/a[1]/div/img")).click();

        driver.close();
    }
    public static void xpathRelativo(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.magazineluiza.com.br/");

        driver.findElement(By.xpath("//input[@id='inpHeaderSearch']")).sendKeys("Celular");
        driver.findElement(By.xpath("//span[contains(@title, 'scar')]")).click(); //contains

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, 200)");

        driver.findElement(By.xpath("//option[contains(@value, 'mais-vendidos')]")).click(); //filtro
        driver.findElement(By.xpath("//*[contains(@alt, 'Smartphone Samsung Galaxy A02s 32GB 4G Octa-Core 3GB RAM 6.5”')]")).click();


    }
}
