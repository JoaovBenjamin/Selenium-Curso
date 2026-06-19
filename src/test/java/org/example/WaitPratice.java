package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitPratice {
    static void main() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        login(driver, wait,"rahulshettyacademy","Learning@830$3mK2");
        addItens(driver);

    }

    public static void login(WebDriver driver, WebDriverWait wait,String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement elementDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(elementDropdown);
        dropdown.selectByIndex(2);
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='terms']"));
        checkbox.click();
        driver.findElement(By.id("signInBtn")).click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("iphone X")));
            System.out.println("Login com sucesso");
        }catch (Exception e){
            System.out.println("Login falhou");
        }
    }
    public static void addItens( WebDriver driver){
        List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for(int i =0; i<products.size(); i++) {
            products.get(i).click();
        }
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }
}
