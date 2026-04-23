package tests;

import pages.LoginPage;
import pages.AdminPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test
    public void testAdminUserRoleCreation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        AdminPage adminPage = new AdminPage(driver);
        adminPage.navigateToAdmin();        
        String testUser = "User_" + System.currentTimeMillis();
        adminPage.createSystemUser("Orange", testUser, "Pass@1234");
        
        Assert.assertTrue(adminPage.isUserCreated(), "Admin user creation failed!");
    }
}