package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest {
    String name = "Automation Tester";
    String email = "automation@testing.com";
    String subject = "The Subject";
    String message = "This is a message";

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://browserstacktraining.site");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void contactUsFormTest() {
        try {
            driver.findElement(By.cssSelector("#contactButton")).click();

            driver.findElement(By.cssSelector("#name")).sendKeys(name);
            driver.findElement(By.cssSelector("#email")).sendKeys(email);
            driver.findElement(By.cssSelector("#subject")).sendKeys(subject);
            driver.findElement(By.cssSelector("#message")).sendKeys(message);

            driver.findElement(By.cssSelector("#submit")).click();

            Assert.assertTrue(driver.findElement(By.cssSelector("#successMessage")).isDisplayed());
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
