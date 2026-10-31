package com.qa.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME, value = "com.qa.stepdefs,com.qa.hooks")
@ConfigurationParameter(key = io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html")
public class MyTestRunner {
}