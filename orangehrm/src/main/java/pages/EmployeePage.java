package pages;
import base.BasePage;
import org.openqa.selenium.*;

public class EmployeePage extends BasePage {
    private By pimModule = By.xpath("//a[contains(@href, 'viewPimModule')]");
    private By addButton = By.xpath("//button[contains(.,'Add')]");
    private By firstNameField = By.name("firstName");
    private By middleNameField = By.name("middleName");
    private By lastNameField = By.name("lastName");
    private By employeeIdField = By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    private By loginDetailsToggle = By.xpath("//span[contains(@class, 'oxd-switch-input')]");
    private By usernameField = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
    private By passwordField = By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input");
    private By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By successToast = By.id("oxd-toaster_1");

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPIM() {
        System.out.println(" Navigating to PIM Module...");
        click(pimModule);
    }

    public void fillFullEmployeeDetails(String fname, String mname, String lname, String loginUser, String loginPass) {
        System.out.println("[Sriya-Log] Clicking Add Button...");
        click(addButton);
        System.out.println("[Sriya-Log] Filling Name Details...");
        waitForElementVisible(firstNameField).sendKeys(fname);
        sendKeys(middleNameField, mname);
        sendKeys(lastNameField, lname);
        System.out.println("[Sriya-Log] Toggling Create Login Details...");
        click(loginDetailsToggle);
        waitForElementVisible(usernameField).sendKeys(loginUser);
        sendKeys(passwordField, loginPass);
        sendKeys(confirmPasswordField, loginPass);
        
        System.out.println("[Dhathri-Log] Saving Employee...");
        click(saveButton);
    }

    public boolean isEmployeeAdded() {
        try {
            return waitForElementVisible(successToast).isDisplayed();
        } catch (Exception e) {
            System.out.println("[Dhathri-Log] Success Toast not found - check for validation errors.");
            return false;
        }
    }

	public By getEmployeeIdField() {
		return employeeIdField;
	}

	public void setEmployeeIdField(By employeeIdField) {
		this.employeeIdField = employeeIdField;
	}
}