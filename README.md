# 🧪 Swag Labs Automation Framework

This repository contains the automation of the [Swag Labs](https://www.saucedemo.com/) site 
using a **BDD Framework** combining the **Page Object Model (POM)** with **Selenium Java**, **Cucumber**, **PageFactory**, **JUnit**, and **Allure Reports**.

---

## 📁 Project Structure
src

└── test

└── java

├── features # Cucumber feature files (Login, Logout, Purchase flows)

├── hooks # Hooks for setup and teardown (e.g., WebDriver init)

├── pages # Page classes using PageFactory and POM

├── runner # TestRunner class for Cucumber + JUnit

└── stepDefinitions # Step definition classes for feature steps

---

## ✅ Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **Page Object Model (POM)**
- **PageFactory**
- **JUnit**
- **Maven** (Build tool)
- **Allure Reports** (Test reporting)

---

🧪 Test Scenarios Covered

🔐 Login Functionality

🚪 Logout Functionality

🛒 Purchase Single Item Flow

*** More scenarios will be added incrementally.

---

📌 Notes

-> Follows industry standard BDD + POM design

-> WebElements are handled using PageFactory for efficient loading

-> Reusable Hooks class for driver management and cleanup

---

## 🚀 How to Run

# 1. Clone the project repository
git clone https://github.com/your-username/swagLabs-automation.git

cd swagLabs-automation

# 2. Clean and build the project with Maven
mvn clean install

# 3. Run the test suite using JUnit + Cucumber runner
mvn test

# 4. Generate and view the Allure report (make sure Allure is installed)
allure serve allure-results

---

🙋‍♂️ Author

👤 Mohamed M

📍 Tech Stack: Selenium Java, Cucumber, JUnit, POM, Maven, Git, Allure report

📌 GitHub: https://github.com/0xsameerm


