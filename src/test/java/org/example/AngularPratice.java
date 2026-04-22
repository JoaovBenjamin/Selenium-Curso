package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AngularPratice {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("JoaovvBenjamin");
        driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("joao@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
        if (driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected()){
            System.out.println("True");
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(true);
            System.out.println("False");
        }
        WebElement dropdown = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
        driver.findElement(By.className("btn-success")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());


    }

}
