package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class LeavePage extends BasePage {

    public LeavePage(WebDriver driver) {
        super(driver);
    }

    private By leaveMenu = By.xpath("//span[text()='Leave']");
    private By applyTab = By.xpath("//a[normalize-space()='Apply']");
    private By leaveListTab = By.xpath("//a[normalize-space()='My Leave']");

    private By leaveTypeDropdown = By.xpath("//div[contains(@class,'oxd-select-text')]");
    private By leaveOption = By.xpath("//div[@role='listbox']//div[1]");

    private By fromDate = By.xpath("(//input[contains(@placeholder,'yyyy')])[1]");
    private By toDate = By.xpath("(//input[contains(@placeholder,'yyyy')])[2]");

    private By applyBtn = By.xpath("//button[@type='submit']");
    private By recordRow = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");
    public void navigateToApplyLeave() {
        System.out.println("[Leave] Opening Apply Leave...");

        click(leaveMenu);
        waitForElementVisible(applyTab).click();

        waitForElementVisible(leaveTypeDropdown);
    }
    public void applyLeave(String start, String end) {

        navigateToApplyLeave();

        System.out.println("[Leave] Selecting leave type...");
        click(leaveTypeDropdown);
        click(leaveOption);

        System.out.println("[Leave] Entering dates...");
        updateDate(fromDate, start);
        updateDate(toDate, end);

        System.out.println("[Leave] Clicking Apply...");
        click(applyBtn);
    }
    public boolean isLeaveApplied() {

        System.out.println("[Leave] Checking My Leave list...");

        click(leaveListTab);

        try { Thread.sleep(2000); } catch (Exception e) {}

        try {
            return waitForElementVisible(recordRow).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private void updateDate(By locator, String val) {
        WebElement el = waitForElementVisible(locator);
        el.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        el.sendKeys(val, Keys.TAB);
    }
}