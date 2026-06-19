package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartAutomation {
    static void main() {
        WebDriver drive = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(drive,Duration.ofSeconds(15));

        drive.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<String> produtosDesejados = Arrays.asList("Cucumber", "Brocolli", "Cauliflower", "Beetroot", "Tomato");
        addItens(drive,produtosDesejados);
        drive.findElement(By.cssSelector("img[alt='Cart']")).click();
        drive.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        drive.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        drive.findElement(By.cssSelector("button.promoBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        var texto = drive.findElement(By.cssSelector("span.promoInfo")).getText();
        System.out.println(texto);
    }
    public static void addItens(WebDriver drive, List<String> itens){
        List<WebElement> products = drive.findElements(By.cssSelector("div.product"));
        for (String produtoDesejado : itens){
            for (WebElement product: products){
                String productName = product.findElement(By.cssSelector("h4.product-name")).getText();
                String nomeLimpo = productName.split(" - ")[0];
                if (nomeLimpo.equalsIgnoreCase(produtoDesejado)) {
                    product.findElement(By.xpath(".//button[text()='ADD TO CART']")).click();
                    System.out.println(produtoDesejado + " adicionado ao carrinho!");
                    break;
                }
            }
        }
    }
}
