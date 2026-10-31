package com.qa.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before(order = 0)
    public void launchBrowser() {
        // For now, we will default to Chrome. Later we can read this from a config properties file.
        String browserName = "chrome"; 
        
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        // Take a screenshot if the test fails
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}