package com.test.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	//	plugin = {"pretty"},
		features= {"src/test/resources/features"},
		glue = {"com.serenity.test.stepdefinitions"},
		plugin ={"pretty","html:CustomReports/Reports/html/VISAEligibityCheck/VisaEligibilityCheck.html","json:CustomReports/Reports/html/VISAEligibityCheck/VisaEligibilityCheck.json",},
		dryRun=false
		)
public class CucumberTestSuite {}
