# Submit Order for Ecommerce Website 🛒

This repository contains my **Selenium WebDriver Automation Project** named **"Submit Order for Ecommerce Website"**, developed as part of the *Selenium WebDriver with Java - Basics to Advanced + Frameworks* course by **Rahul Shetty Academy**.  

It demonstrates how to automate core **Ecommerce workflows** such as login, adding products to cart, and submitting an order, using **TestNG** and integrated with **Jenkins CI/CD** for continuous testing.

---

## 📌 Features
- End-to-end automation for **Ecommerce order submission**
- Selenium WebDriver with **Java**
- **TestNG** for test management & reporting
- **Page Object Model (POM)** for code reusability and maintainability
- **Data-driven testing** with TestNG DataProviders
- **Cross-browser testing** (Chrome, Firefox, Edge)
- **Maven** for dependency management
- **Jenkins** integration for CI/CD pipeline execution
- Reports:
  - TestNG HTML Report  
  - Extent Reports (optional)

---

## 🛠️ Tech Stack
- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **CI/CD Tool:** Jenkins  
- **Reporting:** TestNG Reports / Extent Report  

---

## ▶️ How to Run Tests Locally
1️⃣ Clone the Repository
git clone https://github.com/<your-username>/selenium-testng-ecommerce.git
cd selenium-testng-ecommerce

2️⃣ Run Tests with Maven
mvn clean test

3️⃣ View Reports

TestNG report: test-output/index.html

Maven Surefire report: target/surefire-reports

Open these files in a browser to check execution results.

⚙️ Run with Jenkins

Open Jenkins → New Item → select Freestyle Project

Configure Source Code Management (SCM) with your GitHub repo URL

Add a build step:

mvn clean test


Build the project → check results in Console Output and TestNG Reports

