package com.codecool;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        username = dotenv.get("USERNAME");
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
        //driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardName.csv", numLinesToSkip = 1)
    void firstNameInput(String input, boolean expected) {
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys(input);
        String actualBackgroundURL = firstNameInput.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardName.csv", numLinesToSkip = 1)
    void lastNameInput(String input, boolean expected) {
        WebElement firstNameInput = driver.findElement(By.id("lastName"));
        firstNameInput.sendKeys(input);
        String actualBackgroundURL = firstNameInput.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardIDNumber.csv", numLinesToSkip = 1)
    void idNumberInput(String input, boolean expected) {
        WebElement firstNameInput = driver.findElement(By.id("id-card-number"));
        firstNameInput.sendKeys(input);
        String actualBackgroundURL = firstNameInput.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardPersonalID.csv", numLinesToSkip = 1)
    void PersonalIdentificationNumberInput(String input, boolean expected) {
        WebElement firstNameInput = driver.findElement(By.id("id-number"));
        firstNameInput.sendKeys(input);
        String actualBackgroundURL = firstNameInput.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardEmail.csv", numLinesToSkip = 1)
    void emailInput(String input, boolean expected) {
        WebElement firstNameInput = driver.findElement(By.id("inputEmail"));
        firstNameInput.sendKeys(input);
        String actualBackgroundURL = firstNameInput.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardPhone.csv", numLinesToSkip = 1)
    void phoneInput(String input, boolean expected) {
        WebElement firstNameInput = driver.findElement(By.id("inputPhone"));
        firstNameInput.sendKeys(input);
        String actualBackgroundURL = firstNameInput.getCssValue("background-image");
        boolean result = Objects.equals(expectedBackgroundURL, actualBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    
    
}
