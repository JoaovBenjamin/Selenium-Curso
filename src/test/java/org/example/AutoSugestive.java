package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSugestive {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("IND");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='ui-menu-item']")));
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));

        for(WebElement option: options){
            if(option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
    }
}
