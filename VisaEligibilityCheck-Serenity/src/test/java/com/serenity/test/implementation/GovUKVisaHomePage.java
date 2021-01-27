package com.serenity.test.implementation;


import com.test.hooks.Setup;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;

public class GovUKVisaHomePage extends PageObject {
	Setup setup = new Setup();
	EnvironmentVariables env;

	@FindBy(xpath = "//span[text()='Check if you need a UK visa']")
	WebElementFacade HomePageText;

	public void launchGovWebSite() {
		getDriver().get(EnvironmentSpecificConfiguration.from(env).getProperty("environments.sandbox.url"));
	}

	public boolean validateHomePage() {
		return HomePageText.isDisplayed();
	}
}
