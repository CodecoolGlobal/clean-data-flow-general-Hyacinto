package com.codecool;

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
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Objects;


public class LoginPageTest {

    WebDriver driver;
    DashboardPage dashboardPage;
    Utility utility;
    LoginPage loginPage;
    String username, password;
    RegisterPage registerPage;
    String expectedURL;

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5555");
        dashboardPage = new DashboardPage();
        utility = new Utility();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        expectedURL = "http://127.0.0.1:5555/list";

        Dotenv dotenv = Dotenv.load();
        username = dotenv.get("TESTUSERNAME");
        password = dotenv.get("PASSWORD");

        registerPage.registration(driver, username, password);
    }

    @AfterEach
    void tearDown() {
        utility.deleteUsers();
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/loginCredential.csv", numLinesToSkip = 1)
    void testLogin(String username, String password, boolean expected) {
        loginPage.login(driver, username, password);
        String actualURL = driver.getCurrentUrl();
        boolean result = Objects.equals(expectedURL, actualURL);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void testLoginWithInvisiblePassword() {
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys(password);
        String passwordText = passwordInput.getText();
        passwordInput.clear();
        Assertions.assertFalse(Boolean.parseBoolean(passwordText), password);
    }
}
