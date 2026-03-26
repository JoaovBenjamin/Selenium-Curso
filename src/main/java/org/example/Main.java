package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        // Esse Drive Manage posso configurar o Manager do Seleniu e alterar suas configs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Melhor pratica para espera de carragamento de elementos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("hello world");
        driver.findElement(By.name("inputPassword")).sendKeys("teste 123");
        driver.findElement(By.className("submit")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        // A Thread evita o erro de ElementCliked, pois leva alguma tempo para o DOM da tela disponibilizar o botão para clicar.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")));
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("JoaoVVB");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("joaovitorvicentebenjamin@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("123");
        // driver.findElement(By.xpath("(//input[@placeholder='Email'])[1]")).clear();
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();


        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        WebElement checkbox = driver.findElement(By.id("chkboxOne"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
    }
}
