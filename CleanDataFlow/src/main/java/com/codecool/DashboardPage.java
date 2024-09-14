package com.codecool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {
    
    public void logout(WebDriver driver) {
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
    }
    
    public void fillAllMandatoryFields(WebDriver driver) {
        
            WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys("Example");
            
            WebElement lastName= driver.findElement(By.id("lastName"));
            lastName.sendKeys("Student");
      
            WebElement IDCardNumber = driver.findElement(By.id("id-card-number"));
            IDCardNumber.sendKeys("123456AA");
            
            WebElement IDNumber = driver.findElement(By.id("id-number"));
            IDNumber.sendKeys("2-19870423-0726");
            
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys("example@student.com");
            
            WebElement phone = driver.findElement(By.id("inputPhone"));
            phone.sendKeys("+36407206784");

            WebElement address = driver.findElement(By.id("inputAddress"));
            address.sendKeys("Long Street 54.");
            
            WebElement city = driver.findElement(By.id("inputCity"));
            city.sendKeys("BigCity");
    
            WebElement inputField = driver.findElement(By.id("inputCourse"));
            Select dropdown = new Select(inputField);
            dropdown.selectByVisibleText("Budapest");
            
            WebElement zip = driver.findElement(By.id("inputZip"));
            zip.sendKeys("1027");
     
            WebElement average = driver.findElement(By.id("formerAverage"));
            average.sendKeys("5");
            
            WebElement score = driver.findElement(By.id("admissionScore"));
            score.sendKeys("100");
            
            WebElement radioButtonFull = driver.findElement(By.id("fullstack"));
            radioButtonFull.click();
            
            WebElement startDate = driver.findElement(By.id("startDate"));
            startDate.sendKeys("2024-09-16");
    }
}
