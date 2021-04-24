package br.com.rabelonms.javascript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestComandosJavascript {
    static WebDriver driver;
    public static void main(String[] args){
        testJavaScriptFinal();
    }
    public static void testJavaScriptInital(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        //Livro - Sombra e Ossos
        driver.get("https://www.submarino.com.br/");
        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('h_search-input').value='livros';");
        javascriptExecutor.executeScript("document.getElementById('h_search-btn').click();");
        javascriptExecutor.executeScript("window.scrollBy(0, 1500)");
        WebElement livro = driver.findElement(By.cssSelector("img[src='https://images-submarino.b2w.io/produtos/imagens/2894593254/2894593271_1GG.jpg']"));
        javascriptExecutor.executeScript("arguments[0].click();", livro);
        driver.close();
    }
    public static void testJavaScriptFinal(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement checkboxes = driver.findElement(By.cssSelector("a[href='/checkboxes']"));
        //or driver.findElement(By.linkText("Checkboxes"));
        javascriptExecutor.executeScript("arguments[0].click()", checkboxes);
        String title = javascriptExecutor.executeScript("return document.title;").toString();
        System.out.println(title);

        WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        javascriptExecutor.executeScript("arguments[0].checked=true", checkBox);
        javascriptExecutor.executeScript("alert('o elemento foi checkado!')");
        Alert alert = driver.switchTo().alert(); //manipular alert
        alert.accept();
        javascriptExecutor.executeScript("arguments[0].checked=false", checkBox);
        javascriptExecutor.executeScript("history.go(0)"); //refresh
        driver.close();
    }
}
