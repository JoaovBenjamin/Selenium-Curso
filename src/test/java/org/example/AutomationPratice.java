package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AutomationPratice {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

        driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

        List<WebElement> options =driver.findElements(By.cssSelector("input[type = checkbox]"));
        System.out.println("Elementos: " + options.size());
    }
}
