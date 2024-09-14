package com.codecool;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class LogoutTest {

    WebDriver driver;
    RegisterPage registerPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    Utility utility;
    String username,password;

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        driver.get("http://127.0.0.1:5555");
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        utility = new Utility();

        Dotenv dotenv = Dotenv.load();
        username = dotenv.get("TESTUSERNAME");
        password = dotenv.get("PASSWORD");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        utility.deleteUsers();
        utility.deleteStudents();
    }
    
    @Test
    void testSafeLogout() {
        registerPage.registration(driver, username, password);
        loginPage.login(driver, username, password);
        WebElement dataEntryButton = driver.findElement(By.linkText("Data Entry"));
        dataEntryButton.click();
        dashboardPage.fillAllMandatoryFields(driver);
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();
        WebElement list = driver.findElement(By.linkText("List"));
        list.click();
        dashboardPage.logout(driver);
        utility.navigateBackMultipleTimes(driver,1);
        List<WebElement> studentCards = driver.findElements(By.cssSelector(".mb-3"));
        int actualSize = studentCards.size();
        int expectedSize = 0;
        utility.navigateBackMultipleTimes(driver,1);
        dashboardPage.fillAllMandatoryFields(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement submit = driver.findElement(By.cssSelector(".btn"));
        //wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submit.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://127.0.0.1:5555/login";
        Assertions.assertEquals(expectedSize,actualSize);
        Assertions.assertEquals(expectedURL,actualURL);
    }
    
    
}
