package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public boolean insertInput(WebDriver driver, String id, String input, String expectedBackgroundURL) {
        String actualBackgroundURL;
        WebElement inputField = driver.findElement(By.id(id));
            inputField.sendKeys(input);
        actualBackgroundURL = inputField.getCssValue("background-image");
        return Objects.equals(expectedBackgroundURL, actualBackgroundURL);
    }

    public boolean dropdownInput(WebDriver driver, String id, String input, String expectedBackgroundURL) {
        String actualBackgroundURL;
        WebElement inputField = driver.findElement(By.id(id));
        Select dropdown = new Select(inputField);
        if (input != null) {
            dropdown.selectByVisibleText(input);
            actualBackgroundURL = inputField.getCssValue("--bs-form-select-bg-icon");
        }else{
            actualBackgroundURL = inputField.getCssValue("background-image");
        }
        return Objects.equals(expectedBackgroundURL, actualBackgroundURL);   
    }

    public List<Boolean> radioButtons(WebDriver driver) {
        WebElement radioButtonFull = driver.findElement(By.id("fullstack"));
        WebElement radioButtonFront = driver.findElement(By.id("frontend"));
        WebElement radioButtonBack = driver.findElement(By.id("backend"));

        radioButtonFront.click(); 
        radioButtonBack.click();   
        radioButtonFull.click(); 

        boolean radioButtonFullIsSelected = radioButtonFull.isSelected();
        boolean radioButtonFrontIsSelected = radioButtonFront.isSelected();
        boolean radioButtonBackIsSelected = radioButtonBack.isSelected();

        List<Boolean> booleanList = new ArrayList<>();
        booleanList.add(radioButtonFullIsSelected);
        booleanList.add(radioButtonFrontIsSelected);
        booleanList.add(radioButtonBackIsSelected);

        return booleanList; 
    }
    
    public int doubleFillSize(WebDriver driver) {
        fillAllMandatoryFields(driver);
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();
        WebElement dataEntryButton = driver.findElement(By.linkText("Data Entry"));
        dataEntryButton.click();
        fillAllMandatoryFields(driver);
        submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();
        WebElement listButton = driver.findElement(By.linkText("List"));
        listButton.click();
        List<WebElement> studentCards = driver.findElements(By.cssSelector(".mb-3"));
        return studentCards.size();
    }
    
}
