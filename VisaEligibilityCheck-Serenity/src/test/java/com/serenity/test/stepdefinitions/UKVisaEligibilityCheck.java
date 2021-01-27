package com.serenity.test.stepdefinitions;

import org.junit.Assert;

import com.test.pages.HomePage;
import com.test.pages.UKImmigrationStatusChk;
import com.test.pages.VisaChkNationAndReasonCriteriaPage;
import com.test.pages.WorkVisaSelectionCriteriaPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UKVisaEligibilityCheck {
	
	@Steps
	HomePage page;
	@Steps
	VisaChkNationAndReasonCriteriaPage VisaSelpage;
	@Steps
	WorkVisaSelectionCriteriaPage wrkVisaCriSel;
	@Steps
	UKImmigrationStatusChk ukImgStatusChk;
	
	private String nationality;
	private String reasonToVisit;
	
	@Before
	public void launchHomePage() {
		page.launchURL();
	//	scenarioLoc = new ThreadLocal<Scenario>();
	} 
	

	@Given("the UK-Visa Home page")
	public void the_uk_visa_home_page() {
	    Assert.assertTrue(page.validateHomePage());
	}
	
	@When("^user checks eligibility for (.*) nationality with reason to visit UK as (.*)$")
	public void user_checks_eligibility_for_nationality_with_reason_as(String nationality, String reasonToVisit) {
		 this.nationality = nationality;
		 this.reasonToVisit = reasonToVisit;
	     VisaSelpage.selectNationalityAndReason(nationality,reasonToVisit);
	}

	@Then("^should see the message (.*)$")
	public void should_see_the_message(String outcome) { 
		 String visaOutcomeMessage = VisaSelpage.validateOutcome();
		 Assert.assertTrue(visaOutcomeMessage.trim().equals(outcome.trim()));
		 Serenity.recordReportData().withTitle(" Visa Eligibility Outcome message for " + this.nationality + " Nationality to visit UK for " + this.reasonToVisit + " is : ").andContents(visaOutcomeMessage.trim());
	}
	
	@When("^select planning to work in UK as (.*)$")
	public void select_planning_to_work_in_uk_as(String selCriteria) {
		wrkVisaCriSel.WorkVisaCriteriaSele(selCriteria);
	}

	@When("^select family member immigration status (.*)$")
	public void select_family_member_immigration_status(String immgStatus) {
		ukImgStatusChk.FamilyVisaUKImmigrationChk(immgStatus);
	}
	
	@When("^select duration of study in UK as (.*)$")
	public void select_duration_of_study_in_uk_as(String selCriteria) {
		wrkVisaCriSel.WorkVisaCriteriaSele(selCriteria);
	}
	
	@After
	public void teardown() {
		
		System.out.println("***************************************************************");
		System.out.println("*                                                             *");
		System.out.println("*                  Test Ended                                 *");
		System.out.println("*                                                             *");
		System.out.println("*                                                             *");
		System.out.println("***************************************************************");
	}

}
