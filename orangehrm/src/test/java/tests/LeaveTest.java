package tests;

import pages.LoginPage;
import pages.LeavePage;
import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    @Test
    public void testApplyLeaveFlow() {

        System.out.println(">>> STARTING LEAVE TEST <<<");

        LoginPage login = new LoginPage(driver);
        login.login(config.getUsername(), config.getPassword());

        LeavePage leavePage = new LeavePage(driver);

        leavePage.applyLeave("2026-04-20", "2026-04-21");

        boolean result = leavePage.isLeaveApplied();

        System.out.println("Leave Applied Status: " + result);

        Assert.assertTrue(result, "Leave application failed!");

        System.out.println(">>> LEAVE TEST PASSED <<<");
    }
}