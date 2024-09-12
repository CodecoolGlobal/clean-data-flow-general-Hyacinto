package com.codecool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public void login(WebDriver driver, String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector(".btn"));
        loginButton.click();
    }
}
