# 🧪 Quality Engineering Projects Repository

Welcome to the central hub of my Quality Assurance (QA) and Test Automation projects. This repository includes a set of structured and scalable frameworks that showcase real-world examples of modern testing practices using Java and various tools.

## 📁 Repository Structure

This repository contains the following projects:

1. **selenium-testng-pom-TAF** – A full-fledged Test Automation Framework built with Java, TestNG, Selenium, Page Object Model, and more.
2. **restassured-api-testing** – API automation testing framework using RestAssured and TestNG.
3. **playwright-java-pom** – End-to-end UI automation using Playwright with Java, applying Page Object Model.
4. **jmeter-performance-testing** – Sample performance testing scripts and configurations using Apache JMeter.

---

## 🔍 Project: selenium-testng-pom-TAF

A robust, maintainable, and scalable Test Automation Framework (TAF) built with industry best practices. This framework is ideal for testing web applications using Selenium WebDriver, with features like data-driven testing, Allure reporting, parallel execution, and CI integration.

### ✅ Features

- **Java + TestNG** based test execution
- **Page Object Model (POM)** design pattern
- **Explicit Waits Utility**
- **Cross-browser support (Edge, Chrome, etc.)**
- **Log4j2 logging**
- **Allure Reporting**
- **Data-driven testing using JSON & Excel**
- **CI-ready with GitHub Actions**
- **Scalable directory structure**
- **Custom Hooks & Listeners for screenshots and logs**
- **Environment-based execution (local, remote, headless)**

---

### 🧱 Project Structure
TAF/
├── .gitignore
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/automationexercices/
│   │   │       ├── FileUtils.java
│   │   │       ├── Builder.java
│   │   │       ├── UserManagementAPI.java
│   │   │       ├── apis/
│   │   │       ├── drivers/
│   │   │       │   ├── AbstractDriver.java
│   │   │       │   ├── Browser.java
│   │   │       │   ├── ChromeFactory.java
│   │   │       │   ├── EdgeFactory.java
│   │   │       │   ├── FirefoxFactory.java
│   │   │       │   ├── GUIDriver.java
│   │   │       │   ├── SafariFactory.java
│   │   │       │   ├── UITest.java
│   │   │       │   └── WebDriverProvider.java
│   │   │       ├── listeners/
│   │   │       │   └── TestNGListeners.java
│   │   │       ├── media/
│   │   │       │   ├── ScreenRecordManager.java
│   │   │       │   └── ScreenshotsManager.java
│   │   │       ├── pages/
│   │   │       │   ├── CartPage.java
│   │   │       │   ├── CheckoutPage.java
│   │   │       │   ├── ContactUsPage.java
│   │   │       │   ├── DeleteAccountPage.java
│   │   │       │   ├── LogoutPage.java
│   │   │       │   ├── PaymentPage.java
│   │   │       │   ├── ProductDetailsPage.java
│   │   │       │   ├── ProductsPage.java
│   │   │       │   ├── SignupLoginPage.java
│   │   │       │   ├── SignupPage.java
│   │   │       │   ├── TestCasesPage.java
│   │   │       │   └── components/
│   │   │       │       └── NavigationBarComponent.java
│   │   │       ├── utils/
│   │   │       │   ├── OSUtils.java
│   │   │       │   ├── TerminalUtils.java
│   │   │       │   ├── TimeManager.java
│   │   │       │   ├── WaitManager.java
│   │   │       │   ├── actions/
│   │   │       │   │   ├── AlertActions.java
│   │   │       │   │   ├── BrowserActions.java
│   │   │       │   │   ├── ElementActions.java
│   │   │       │   │   └── FrameActions.java
│   │   │       │   ├── dataReader/
│   │   │       │   │   ├── ExcelReader.java
│   │   │       │   │   ├── JsonReader.java
│   │   │       │   │   └── PropertyReader.java
│   │   │       │   ├── logs/
│   │   │       │   │   └── LogsManager.java
│   │   │       │   └── report/
│   │   │       │       ├── AllureAttachmentManager.java
│   │   │       │       ├── AllureBinaryManager.java
│   │   │       │       ├── AllureConstants.java
│   │   │       │       ├── AllureEnvironmentManager.java
│   │   │       │       └── AllureReportGenerator.java
│   │   │       └── validations/
│   │   │           ├── BaseAssertion.java
│   │   │           ├── Validation.java
│   │   │           └── Verification.java
│   ├── resources/
│   │   ├── META-INF/
│   │   │   └── services/
│   │   │       └── org.testng.ITestNGListener
│   │   ├── allure.properties
│   │   ├── db.properties
│   │   ├── environment.properties
│   │   ├── extensions/
│   │   │   └── HaramBlur.crx
│   │   ├── log4j2.properties
│   │   ├── seleniumGrid.properties
│   │   ├── video.properties
│   │   ├── waits.properties
│   │   └── webapp.properties
├── test/
│   ├── java/
│   │   └── com/automationexercices/tests/
│   │       ├── BaseTest.java
│   │       ├── api/
│   │       │   └── RegisterTestAPI.java
│   │       └── ui/
│   │           ├── CartTest.java
│   │           ├── CheckoutTest.java
│   │           ├── InvoiceTest.java
│   │           ├── LoginTest.java
│   │           ├── PaymentTest.java
│   │           ├── ProductDetailsTest.java
│   │           ├── ProductsTest.java
│   │           └── RegisterTest.java
│   └── resources/
│       └── test-data/
│           ├── cart-data.json
│           ├── checkout-data.json
│           ├── login-data.json
│           ├── product-details-data.json
│           ├── products-data.json
│           └── register-data.json


 ## Run the tests
 ``
 mvn test 
 ``

 ## 👨‍💻 Author
### Ahmed Ashraf
#### Senior Test Automation Engineer
🔗 LinkedIn | 📧 ahmedashraaf09@gmail.com
