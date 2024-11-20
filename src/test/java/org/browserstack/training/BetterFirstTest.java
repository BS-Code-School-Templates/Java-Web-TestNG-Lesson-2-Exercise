package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BetterFirstTest {

    @Test
    public void simpleSeleniumTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            WebElement loginButtonElement = driver.findElement(By.cssSelector("#loginButton"));
            loginButtonElement.click();

            driver.findElement(By.cssSelector("#username")).sendKeys("student");

            driver.findElement(By.cssSelector("#password")).sendKeys("Password123");

            driver.findElement(By.cssSelector("#submit")).click();

            assert driver.findElement(By.id("message")).getText().contains("Login successful");

            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }


    }

}