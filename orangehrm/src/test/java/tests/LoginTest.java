package tests;

import pages.LoginPage;
import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testValidLogin() {

        System.out.println(">>> STARTING VALID LOGIN TEST <<<");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(config.getUsername(), config.getPassword());

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Redirected URL: " + currentUrl);

        Assert.assertTrue(currentUrl.contains("dashboard"),
                "Login failed! Dashboard not reached.");

        System.out.println(">>> VALID LOGIN TEST PASSED <<<");
    }

    @Test(priority = 2)
    public void testInvalidLogin() {

        System.out.println(">>> STARTING INVALID LOGIN TEST <<<");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin", "wrong123");

        String error = loginPage.getErrorMessage();
        System.out.println("Error Message: " + error);

        Assert.assertTrue(error.toLowerCase().contains("invalid"),
                "Error message not shown for invalid login");

        System.out.println(">>> INVALID LOGIN TEST PASSED <<<");
    }

    @Test(priority = 3)
    public void testEmptyLogin() {

        System.out.println(">>> STARTING EMPTY LOGIN TEST <<<");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");

        String error = loginPage.getRequiredMessage();
        System.out.println("Validation Message: " + error);

        Assert.assertTrue(error.equalsIgnoreCase("Required"),
                "Validation message not shown for empty login");

        System.out.println(">>> EMPTY LOGIN TEST PASSED <<<");
    }
}