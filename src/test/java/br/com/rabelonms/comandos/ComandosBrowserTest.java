package br.com.rabelonms.comandos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComandosBrowserTest {

    static WebDriver driver;
    public static void main(String[] args){
        comandosBrowser();
    }

    public static void comandosBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rabel\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximizar janela
        driver.get("https://www.facebook.com");
        String titulo = driver.getTitle();
        System.out.println(titulo);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String codigoFonte = driver.getPageSource();
        //System.out.println(codigoFonte);
        driver.close();//fecha a janela atual
        //driver.quit();//fecha todas as janelas
    }
}
