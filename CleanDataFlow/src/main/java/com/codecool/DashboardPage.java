package com.codecool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    
    public void logout(WebDriver driver) {
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
    }
    
    public void fillAllMandatoryFields(WebDriver driver) {}
}
