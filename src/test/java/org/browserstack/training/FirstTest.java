package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void simpleSeleniumTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://browserstacktraining.site");
        driver.manage().window().maximize();

        WebElement loginButtonElement = driver.findElement(By.cssSelector("#loginButton"));
        loginButtonElement.click();

        WebElement usernameElement = driver.findElement(By.cssSelector("#username"));
        usernameElement.sendKeys("student");

        WebElement passwordElement = driver.findElement(By.cssSelector("#password"));
        passwordElement.sendKeys("Password123");

        WebElement submitButtonElement = driver.findElement(By.cssSelector("#submit"));
        submitButtonElement.click();

        WebElement loginMessage = driver.findElement(By.id("message"));
        assert loginMessage.getText().contains("Login successful");
        assert loginMessage.isDisplayed();

        driver.quit();


    }

}