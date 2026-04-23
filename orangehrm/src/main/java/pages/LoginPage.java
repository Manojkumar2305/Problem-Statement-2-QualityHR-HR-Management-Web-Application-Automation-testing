package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // 🔹 Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");

    // 🔹 Error messages
    private By invalidError = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    private By requiredError = By.xpath("//span[text()='Required']");

    // 🔹 Actions
    public void enterUsername(String user) {
        waitForElementVisible(usernameField).clear();
        sendKeys(usernameField, user);
    }

    public void enterPassword(String pass) {
        waitForElementVisible(passwordField).clear();
        sendKeys(passwordField, pass);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    // 🔹 Combined Login
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    // 🔹 Validation - Invalid credentials
    public String getErrorMessage() {
        return waitForElementVisible(invalidError).getText();
    }

    // 🔹 Validation - Empty fields
    public String getRequiredMessage() {
        return waitForElementVisible(requiredError).getText();
    }
}