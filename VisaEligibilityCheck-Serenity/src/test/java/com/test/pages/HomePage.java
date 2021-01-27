package com.test.pages;

import com.serenity.test.implementation.GovUKVisaHomePage;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;

public class HomePage {
	
	GovUKVisaHomePage govUKPage;

	@Screenshots(disabled=true)
	public void launchURL() {
		govUKPage.launchGovWebSite();
		
	}
	
	@Step
	public boolean validateHomePage() {
		return govUKPage.validateHomePage();
	}
}
