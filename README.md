# Selenium Automation Projects  

![Java](https://img.shields.io/badge/Java-11%2B-007396?logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-IDE-000000?logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-Web%20Automation-43B02A?logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Framework-FF6C37?logo=testng&logoColor=white)
![AssertJ](https://img.shields.io/badge/AssertJ-Assertions-6DB33F)
![Allure](https://img.shields.io/badge/Allure-Reports-FF69B4?logo=qameta&logoColor=white)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-CC0000?logo=apache&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache%20POI-Excel%20Support-2496ED?logo=apache&logoColor=white)

---

## 🗂️ Overview  

This repository contains **Selenium-based UI automation projects** developed using **Java, Selenium WebDriver, TestNG, Maven, and Allure Reports**.

The framework follows **Page Object Model (POM)** principles and supports:
- Multiple web applications
- Retry logic
- Screenshot capture on failure
- Centralised configuration
- Scalable test execution via TestNG XMLs

---

## ⚙️ Tech Stack

- **Java 11+**
- **IntelliJ IDEA** – IDE for development
- **Maven** – Build & dependency management
- **Selenium WebDriver** – Browser automation
- **TestNG** – Testing framework
- **Log4j2** – Centralized logging and debugging
- **Page Object Model (POM)** design pattern
- **Allure Reports** – Reporting framework

---

## 🚀 Features

- **Selenium WebDriver automation** using Java
- **Page Object Model (POM)** based framework design
- Supports **multiple applications** within a single framework :
    - Amazon
    - Flipkart
    - Applitools Demo App
    - Practice Test Automation App
- **Reusable base classes** for pages and tests
- **Centralised WebDriver management**
- **Explicit wait utilities** for stable test execution
- **Retry mechanism** for failed tests using TestNG RetryAnalyzer
- **Automatic screenshot capture on test failure**
- **TestNG listeners** for execution control and reporting
- **External configuration** using `data.properties`
- **Structured logging** using Log4j2
- **Test execution via TestNG XML suites**
- **Allure Reports integration** for detailed execution reports

---

## 🧩 Framework Highlights

### 🧱 Base Classes

- **`CommonToAllPage.java`** – Base class for all Page Objects, providing common web actions, driver access, and shared utilities
- **`CommonToAllTest.java`** – Base class for all test cases, responsible for test setup, teardown, and environment initialisation
  
##

### 🧪 Utilities

- **`DriverManager.java`** – Centralised WebDriver lifecycle management for consistent browser handling
- **`PropertiesReader.java`** – Reads and manages configuration values from `data.properties`
- **`WaitHelpers.java`** – Utility class for handling explicit and conditional waits

##

### 🔁 Listeners

- **`RetryAnalyzer.java`** – Automatically retries failed test cases
- **`RetryListeners.java`** – Automatically retries failed test cases
- **`ScreenshotListeners.java`** – Captures screenshots automatically on test failures
  
## 

### 📚 Application Modules

| Application Module         | Description                                      |
| -------------------------- | ------------------------------------------------ |
| **amazon**                 | UI automation for Amazon user flows              |
| **flipkart**               | UI automation for Flipkart user flows            |
| **applitools**             | Tests for Applitools demo application            |
| **practiceTestAutomation** | Login and dashboard automation for practice site |

---

## 🌐 Applications Automated  

- **Amazon**
- **Flipkart**
- **Applitools Demo App**
- **Practice Test Automation App**

Each application is automated as an **independent module**, ensuring clear separation and maintainability:

- Dedicated **Page Object** classes
- Dedicated **Test classes**
- Separate **TestNG XML suites** for controlled execution

This structure allows tests to be **scalable**, **reusable**, and **easy to extend** as new applications are added.

---

## 🏗️ Project Structure  

```bash
Selenium_Automation_Projects/
│
├── .idea/                                                        # IntelliJ project files
├── .mvn/                                                         # Maven wrapper files
├── allure-results/                                               # Allure test results
├── failure_screenshots/                                          # Screenshots captured on test failures
├── logs/                                                         # Execution logs
├── screenshots/                                                  # Additional screenshots
│
├── src/
│   ├── main/java/com.avinashsinha/
│   │   ├── base/                                                 # Base page setup
│   │   │   └── CommonToAllPage.java
│   │   │
│   │   ├── driver/                                               # WebDriver management
│   │   │   └── DriverManager.java
│   │   │
│   │   ├── pages/                                                # Page Object classes
│   │   │   ├── amazon/
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckoutCumLoginPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   └── SearchPage.java
│   │   │   │
│   │   │   ├── applitools/
│   │   │   │   ├── DashboardPage.java
│   │   │   │   └── LoginPage.java
│   │   │   │
│   │   │   ├── flipkart/
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckoutCumLoginPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   └── SearchPage.java
│   │   │   │
│   │   │   └── practiceTestAutomation/
│   │   │       ├── DashboardPage.java
│   │   │       └── LoginPage.java
│   │   │
│   │   └── utils/                                                # Utilities
│   │       ├── PropertiesReader.java
│   │       └── WaitHelpers.java
│   │
│   ├── main/resources/
│   │   ├── data.properties                                       # Configuration file
│   │   └── log4j2.xml                                            # Logging configuration
│   │
│   └── test/java/com.avinashsinha/
│       ├── base/                                                 # Base test setup
│       │   └── CommonToAllTest.java
│       │
│       ├── listeners/                                            # TestNG listeners
│       │   ├── RetryAnalyzer.java
│       │   ├── RetryListeners.java
│       │   └── ScreenshotListeners.java
│       │
│       └── tests/                                                # Test classes
│           ├── amazon/
│           │   └── TestAmazonPage.java
│           │
│           ├── applitools/
│           │   └── TestAppliToolsPage.java
│           │
│           ├── flipkart/
│           │   └── TestFlipkartPage.java
│           │
│           └── practiceTestAutomation/
│               └── TestPracticeTestAutomationPage.java
│
├── testNG-xmls/                                                  # TestNG suite files
│   ├── testng_AmazonPage.xml
│   ├── testng_AppliToolsPage.xml
│   ├── testng_FlipkartPage.xml
│   └── testng_PracticeTestAutomationPage.xml
│
├── pom.xml                                                       # Maven configuration
├── .gitignore
└── README.md
```

---

## ▶️ Running Tests

### Run a Specific TestNG Suite

```bash
mvn clean test -DsuiteXmlFile=testNG-xmls/testng_AmazonPage.xml
```

#### Commonly Used TestNG Suites

| TestNG File                             | Purpose                                    |
| --------------------------------------- | ------------------------------------------ |
| `testng_AmazonPage.xml`                 | Amazon application UI tests                |
| `testng_FlipkartPage.xml`               | Flipkart application UI tests              |
| `testng_AppliToolsPage.xml`             | Applitools demo application tests          |
| `testng_PracticeTestAutomationPage.xml` | Practice Test Automation application tests |

---

## 📊 Reporting

### Generate Allure Report

```bash
allure serve allure-results
```

This opens a **beautiful interactive report** in your browser, showing execution summary, test logs, and screenshots for failed tests.

Example Allure dashboard view:

<img width="1920" height="1114" alt="image" src="https://github.com/user-attachments/assets/a21482fe-9873-48b5-a922-51b3d9516c90" />

---

## 📌 Author
👤 Avinash Sinha

---

🧠 This repository is designed for **advanced Selenium UI automation learning and practice**, focusing on **real-world framework design**, **scalability**, **reusability**, and **maintainability**.
Future **Selenium + Java automation projects** will be continuously added to this repository.


---
