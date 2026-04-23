# 2-QualityHR-HR-Management-Web-Application-Automation-testing
QualityHR is a Selenium-Java automation framework built using TestNG and Page Object Model (POM) to automate end-to-end HR workflows including login, employee management, leave handling, and user role management.


QualityHR – Selenium Java Automation Framework

QualityHR is a Selenium WebDriver-based automation framework developed using Java and TestNG. It follows the Page Object Model (POM) design pattern to ensure clean, reusable, and maintainable code. The framework automates end-to-end workflows of an HR Management system including authentication, employee management, leave processing, and admin operations.

---

Objective:

* Build a scalable HR automation framework
* Automate real-world business workflows
* Implement POM-based architecture
* Enable data-driven and configurable testing

---

Application Under Test:
URL: https://opensource-demo.orangehrmlive.com

Default Credentials:
Username: admin
Password: admin123 

---

Features Covered:

1. User Authentication

* Login with valid and invalid credentials
* Logout functionality
* Validation for empty inputs

2. Employee Management

* Add new employee
* Search employee by name
* View and verify employee details

3. Leave Management

* Apply for leave
* Verify leave status
* Handle invalid date scenarios

4. User Role Management

* Create new system user
* Assign roles (ESS/Admin)
* Delete user and verify removal

5. Form Validations

* Mandatory field validation
* Invalid input handling
* Dropdown validation

---

Framework Architecture:

SeleniumPOMFramework/
│
├── pom.xml
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       │   └── BaseTest.java
│   │       │
│   │       ├── pages/
│   │       │   ├── LoginPage.java
│   │       │   ├── EmployeePage.java
│   │       │   ├── LeavePage.java
│   │       │   ├── AdminPage.java
│   │       │
│   │       ├── utils/
│   │       │   ├── ConfigReader.java
│   │       │   ├── WaitHelper.java
│   │       │
│   │       └── driver/
│   │           └── DriverFactory.java
│   │
│   ├── test/
│   │   └── java/
│   │       ├── tests/
│   │       │   ├── LoginTest.java
│   │       │   ├── EmployeeTest.java
│   │       │   ├── LeaveTest.java
│   │       │   ├── AdminTest.java
│   │       │
│   │       └── listeners/
│   │           └── TestListener.java
│
│   └── resources/
│       ├── config.properties
│       └── testdata.xlsx
│
└── testng.xml

---

Tech Stack:

* Java
* Selenium WebDriver
* TestNG
* WebDriverManager
* ExtentReports

---

Key Implementations:

Page Object Model:

* Dedicated Page classes for each module
* Reusable methods for UI interactions
* No WebDriver code inside test classes

TestNG:

* BeforeMethod and AfterMethod for setup and teardown
* DataProvider for login test data
* testng.xml for execution

Configuration:

* Centralized config.properties
* Browser, URL, and timeout configurable
* No hardcoded values

Wait Strategy:

* Explicit waits using WebDriverWait
* No Thread.sleep() used

Reporting:

* ExtentReports for HTML reporting
* Screenshot capture on failure using TestNG Listeners

---

How to Run:

mvn clean test

OR run using testng.xml

---

Known Issues / Limitations:

Some test cases may occasionally fail due to the dynamic behavior of the HR application:

* UI elements load asynchronously after actions like login or employee creation
* DOM updates may cause stale element reference exceptions
* Table data and search results dynamically refresh
* Timing issues may occur due to network or server response delays

These are common real-world automation challenges. Future improvements include:

* Retry mechanism for failed tests
* FluentWait for better synchronization
* More stable and dynamic locator strategies

---

Reporting:

* HTML report generated after execution
* Includes test status and screenshots on failure

---

Best Practices:

* Clean and modular structure
* Reusable utilities and page methods
* No hardcoding
* Maintainable and scalable design


Author:
Manoj
