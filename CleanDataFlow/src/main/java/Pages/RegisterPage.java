package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    
    public void registration(WebDriver driver, String username, String password ) {
        WebElement signUpButton = driver.findElement(By.linkText("Sign up"));
        signUpButton.click();
        WebElement usernameInput = driver.findElement(By.id("user"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys(password);
        WebElement passwordConfirmInput = driver.findElement(By.id("inputPasswordConfirmation"));
        passwordConfirmInput.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector(".btn"));
        submitButton.click();
    }
}
