package com.serenity.test.implementation;

import com.test.utils.Report;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GovUKVisaNationAndReaSelecCriteria extends PageObject {
    WebDriver driver;
    Report report;

    public GovUKVisaNationAndReaSelecCriteria(WebDriver driver){
          this.driver = driver;
          report = new Report();
    }
	
    
    @FindBy(xpath="//select[@id='response']")
    WebElementFacade selCntryDrpDwn;
    
    @FindBy(xpath="//button[contains(text(),'Continue')]")
    WebElementFacade clkOnCtySelContBtn;
    
    @FindBy(xpath="//div[@class='govuk-radios']/ancestor::div//button[contains(text(),'Continue')]")
    WebElementFacade clkOnReasonToVisitContBtn;
    
    @FindBy(xpath="(//div[@id='result-info']//h2)[1]")
    WebElementFacade valVisaOutcomeMsg;

    @FindBy(xpath="//span[text()='Check if you need a UK visa']")
    WebElementFacade wtForVisaReaSelChk;
    
    
    
    public void selectNationalityAndReason(String nationality,String reason) {
    	String selReasonToVisit = "//label[contains(text(),'"+reason.trim()+"')]/parent::div//input[@type='radio']";
    	selCntryDrpDwn.selectByVisibleText(nationality);
    	clkOnCtySelContBtn.click();
        waitForCondition().until(ExpectedConditions.textToBePresentInElement(wtForVisaReaSelChk,"Check if you need a UK visa"));
    	WebElementFacade ele_seleReason = $(By.xpath(selReasonToVisit.trim()));
    	ele_seleReason.click();
    	if(clkOnReasonToVisitContBtn.isEnabled()){
    	clkOnReasonToVisitContBtn.click();
            System.out.println("IF Condition executing");
            Report.fail("Not able to find the Continue Button",driver);
        }
    	else {
    	    System.out.println("Else Condition executing");
        }

    }
    
    
    public String validateOutcome() {
        return valVisaOutcomeMsg.getText().trim();
    }
}
