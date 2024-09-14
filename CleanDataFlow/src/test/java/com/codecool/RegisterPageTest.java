package com.codecool;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

class RegisterPageTest {

    WebDriver driver;
    RegisterPage registerPage;
    Utility utility;
    String expectedURL;
    String username,password;

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5555");
        registerPage = new RegisterPage();
        expectedURL = "http://127.0.0.1:5555/login";
        utility = new Utility();

        Dotenv dotenv = Dotenv.load();
        username = dotenv.get("TESTUSERNAME");
        password = dotenv.get("PASSWORD");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        utility.deleteUsers();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registration.csv", numLinesToSkip = 1)
    void testRegistration(String username, String password, boolean expected) {
        registerPage.registration(driver, username, password);
        String actualURL = driver.getCurrentUrl();
        boolean result = Objects.equals(expectedURL, actualURL);
        Assertions.assertEquals(expected,result);
    }
    
    @Test
    void testRegistrationWithSameCredentials() {
        registerPage.registration(driver, username, password);
        String actualURL1 = driver.getCurrentUrl();
        utility.navigateBackMultipleTimes(driver,1);
        registerPage.registration(driver, username, password);
        String actualURL2 = driver.getCurrentUrl();
        Assertions.assertNotEquals(actualURL1,actualURL2);
    }
    
    
    
}