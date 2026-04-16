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
import java.util.List;

public class WebElementUITesting {
    static void main() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        WebElement seniorCheckbox = driver.findElement(By.cssSelector("input[id$='ctl00_mainContent_chk_SeniorCitizenDiscount']"));

        System.out.println(seniorCheckbox.isSelected());
        Assert.assertFalse(seniorCheckbox.isSelected());
        seniorCheckbox.click();
        System.out.println(seniorCheckbox.isSelected());
        Assert.assertTrue(seniorCheckbox.isSelected());

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("Total de checkboxes: " + allCheckboxes.size());
        Assert.assertEquals(allCheckboxes.size(), 6);

        driver.findElement(By.id("divpaxinfo")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnclosepaxoption")));
        for (int i = 0; i < 5; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='BLR']")));
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

    }

}
