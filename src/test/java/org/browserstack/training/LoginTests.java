package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    String correctUsername = "student";
    String correctPassword = "Password123";
    String wrongUsername = "wrongstudent";
    String wrongPassword = "Password456";

    String successMessage = "Login successful!";
    String incorrectUsernameMessage = "Incorrect username!";
    String incorrectPasswordMessage = "Incorrect password!";
    String incorrectUserAndPassMessage = "Incorrect username and password!";

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successfulLoginTest() {
        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(correctUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(correctPassword);
            driver.findElement(By.cssSelector("#submit")).click();

            Assert.assertEquals(driver.findElement(By.id("message")).getText(), successMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }


    }

    @Test
    public void failedLoginTestUsername() {
        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(wrongUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(correctPassword);
            driver.findElement(By.cssSelector("#submit")).click();


            Assert.assertEquals(driver.findElement(By.id("message")).getText(), incorrectUsernameMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedLoginTestPassword() {
        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(correctUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(wrongPassword);
            driver.findElement(By.cssSelector("#submit")).click();

            Assert.assertEquals(driver.findElement(By.id("message")).getText(), incorrectPasswordMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedLoginTestUsernameAndPassword() {
        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(wrongUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(wrongPassword);
            driver.findElement(By.cssSelector("#submit")).click();

            Assert.assertEquals(driver.findElement(By.id("message")).getText(), incorrectUserAndPassMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
