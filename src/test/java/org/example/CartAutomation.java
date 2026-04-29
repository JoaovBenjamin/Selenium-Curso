package org.example;

import io.netty.handler.ssl.util.LazyJavaxX509Certificate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartAutomation {
    static void main() {
        WebDriver drive = new ChromeDriver();
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        drive.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<WebElement> products = drive.findElements(By.cssSelector("div.product"));
        List<String> produtosDesejados = Arrays.asList("Cucumber", "Brocolli", "Cauliflower", "Beetroot", "Tomato");
        for (String produtoDesejado : produtosDesejados){
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
