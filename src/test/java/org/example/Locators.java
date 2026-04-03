package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Locators {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String password = getPassword(driver,wait);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        System.out.println(driver.findElement(By.tagName("p")).getText());

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Hello rahul,']")).getText(), "Hello rahul,");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        driver.close();


    }

    public static String getPassword(WebDriver driver, WebDriverWait wait){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")));
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();

        String[] passwordArray = passwordText.split("'");

        String password = passwordArray[1].split("'")[0];

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputUsername")));

        return password;
    }
}
