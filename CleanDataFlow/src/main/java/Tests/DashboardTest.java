package Tests;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.Utility;
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

import java.util.ArrayList;
import java.util.List;

public class DashboardTest {
    WebDriver driver;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    String username, password;
    RegisterPage registerPage;
    String expectedBackgroundURL;
   
    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        driver.get("http://127.0.0.1:5555");
        dashboardPage = new DashboardPage();
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
        Utility.deleteUsers();
        Utility.deleteStudents();
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardFirstName.csv", numLinesToSkip = 1)
    void firstNameInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver, id, input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardLastName.csv", numLinesToSkip = 1)
    void lastNameInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardIDNumber.csv", numLinesToSkip = 1)
    void idNumberInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardPersonalID.csv", numLinesToSkip = 1)
    void PersonalIdentificationNumberInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardEmail.csv", numLinesToSkip = 1)
    void emailInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardPhone.csv", numLinesToSkip = 1)
    void phoneInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardStreetAddress.csv", numLinesToSkip = 1)
    void streetAddressInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardCity.csv", numLinesToSkip = 1)
    void cityInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardCounty.csv", numLinesToSkip = 1)
    void countyInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.dropdownInput(driver, id, input, expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardZip.csv", numLinesToSkip = 1)
    void zipCodeInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardAverage.csv", numLinesToSkip = 1)
    void formerAverageInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardAdmissionScore.csv", numLinesToSkip = 1)
    void admissionScoreInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @Test
    void testRadioButton() {
        List<Boolean> Expected = new ArrayList<>();
        Expected.add(true);
        Expected.add(false);
        Expected.add(false);
        List<Boolean>Actual = dashboardPage.radioButtons(driver);
        Assertions.assertEquals(Expected,Actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dashboardStartDate.csv", numLinesToSkip = 1)
    void startDateInput(String id, String input, boolean expected) {
        boolean result = dashboardPage.insertInput(driver,id,input,expectedBackgroundURL);
        Assertions.assertEquals(expected,result);
    }
    
    @Test
    void sameStudents() {
        int actualSize = dashboardPage.doubleFillSize(driver);
        int expectedSize = 1;
        Assertions.assertEquals(expectedSize,actualSize);
    }
    
    
   

    
    
    
    
    
    
}
