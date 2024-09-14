package com.codecool;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;


public class DashboardTest {
    WebDriver driver;
    DashboardPage dashboardPage;
    Utility utility;
    LoginPage loginPage;
    String username, password;
    RegisterPage registerPage;
    String expectedBackgroundURL;
   
    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5555");
        dashboardPage = new DashboardPage();
        utility = new Utility();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

        Dotenv dotenv = Dotenv.load();
        username = dotenv.get("TESTUSERNAME");
        password = dotenv.get("PASSWORD");
        expectedBackgroundURL = dotenv.get("EXPECTEDURL");
        
        registerPage.registration(driver, username, password);
        loginPage.login(driver, username, password);
        WebElement dataEntryButton = driver.findElement(By.linkText("Data Entry"));
        dataEntryButton.click();
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();
    }

    @AfterEach
    void tearDown() {
        utility.deleteUsers();
        utility.deleteStudents();
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardName.csv", numLinesToSkip = 1)
    void firstNameInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("firstName"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardName.csv", numLinesToSkip = 1)
    void lastNameInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("lastName"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardIDNumber.csv", numLinesToSkip = 1)
    void idNumberInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("id-card-number"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardPersonalID.csv", numLinesToSkip = 1)
    void PersonalIdentificationNumberInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("id-number"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardEmail.csv", numLinesToSkip = 1)
    void emailInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("inputEmail"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardPhone.csv", numLinesToSkip = 1)
    void phoneInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("inputPhone"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardStreetAddress.csv", numLinesToSkip = 1)
    void streetAddressInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("inputAddress"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardCity.csv", numLinesToSkip = 1)
    void cityInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("inputCity"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardCounty.csv", numLinesToSkip = 1)
    void countyInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("inputCourse"));
        Select dropdown = new Select(inputField);
        dropdown.selectByVisibleText(input);
        String actualBackgroundURL = inputField.getCssValue("--bs-form-select-bg-icon");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardZip.csv", numLinesToSkip = 1)
    void zipCodeInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("inputZip"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardAverage.csv", numLinesToSkip = 1)
    void formerAverageInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("formerAverage"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardAdmissionScore.csv", numLinesToSkip = 1)
    void admissionScoreInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("admissionScore"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @Test
    void testRadioButton() {
        WebElement radioButtonFull = driver.findElement(By.id("fullstack"));
        WebElement radioButtonFront = driver.findElement(By.id("frontend"));
        WebElement radioButtonBack = driver.findElement(By.id("backend"));
        radioButtonFront.click();
        radioButtonBack.click();
        radioButtonFull.click();
        Assertions.assertTrue(radioButtonFull.isSelected());
        Assertions.assertFalse(radioButtonFront.isSelected());
        Assertions.assertFalse(radioButtonBack.isSelected());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardStartDate.csv", numLinesToSkip = 1)
    void startDateInput(String input, boolean expected) {
        WebElement inputField = driver.findElement(By.id("startDate"));
        inputField.sendKeys(input);
        String actualBackgroundURL = inputField.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    
   

    
    
    
    
    
    
}
