package tests;

import pages.LoginPage;
import pages.EmployeePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {
    @DataProvider(name = "employeeData")
    public Object[][] getEmployeeData() {
        return new Object[][] {
            { "Sriya", "QA", "Putty", "sriya_user_" + System.currentTimeMillis(), "Pass12345!" }
        };
    }

    @Test(dataProvider = "employeeData")
    public void testAddEmployeeWithFullDetails(String fn, String mn, String ln, String un, String pw) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());
        EmployeePage empPage = new EmployeePage(driver);
        empPage.navigateToPIM();
        empPage.fillFullEmployeeDetails(fn, mn, ln, un, pw);
        Assert.assertTrue(empPage.isEmployeeAdded(), "FAILED: Employee record was not saved successfully!");
    }
}