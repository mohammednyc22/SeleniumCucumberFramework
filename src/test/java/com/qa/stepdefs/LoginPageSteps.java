package com.qa.stepdefs;

import org.junit.jupiter.api.Assertions;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    private static String title;
    
    private LoginPage getLoginPage() {
        return new LoginPage(DriverFactory.getDriver());
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = getLoginPage().getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, title);
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        getLoginPage().enterUsername(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        getLoginPage().enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        getLoginPage().clickLogin();
    }

    @Then("user should be navigated to products page")
    public void user_should_be_navigated_to_products_page() {
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("inventory.html"));
    }
}