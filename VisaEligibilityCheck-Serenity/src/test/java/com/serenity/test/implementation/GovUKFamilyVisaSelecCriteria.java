package com.serenity.test.implementation;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This Class contains page Objects related to Family Immigration Check Status
 *
 */

public class GovUKFamilyVisaSelecCriteria extends PageObject {

    @FindBy(xpath = "//div[@class='govuk-radios']/ancestor::div//button[contains(text(),'Continue')]")
    private WebElementFacade clkReaToVisitImmChkConBtn;

	@FindBy(xpath="//span[text()='Check if you need a UK visa']")
	WebElementFacade wtForVisaReaSelChk;

	public void FamilyVisaUKImmigrationChk(String immgStatus) {
		String imgStatusChk = "//label[contains(text(),'" + immgStatus + "')]/parent::div//input[@type='radio']";
		waitForCondition().until(ExpectedConditions.textToBePresentInElement(wtForVisaReaSelChk,"Check if you need a UK visa"));
		WebElementFacade ele_famUKImmgChk = $(By.xpath(imgStatusChk));
		ele_famUKImmgChk.click();
		clkReaToVisitImmChkConBtn.click();
	}

}
