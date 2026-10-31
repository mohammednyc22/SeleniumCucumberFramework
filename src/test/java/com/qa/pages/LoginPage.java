package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // 1. By Locators (Encapsulation)
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-button");

    // 2. Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Page Actions / Methods
    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}