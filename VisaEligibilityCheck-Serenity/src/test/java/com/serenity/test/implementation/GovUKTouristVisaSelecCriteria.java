package com.serenity.test.implementation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GovUKTouristVisaSelecCriteria extends PageObject {

    @FindBy(xpath="//label[contains(text(),'Yes')]/parent::div//input[@type='radio']")
    WebElementFacade clkTourismVisitSelCriBtn;

    @FindBy(xpath="//span[text()='Check if you need a UK visa']")
    WebElementFacade wtForVisaReaSelChk;

    public void SelTourismVisaSelCriteria(String selCriteria){
        String selTourismCriteria = "//label[contains(text(),'"+selCriteria+"')]/parent::div//input[@type='radio']";
        WebElementFacade clkTourismVisitSelCriBtn =  $(By.xpath(selCriteria));
        clkTourismVisitSelCriBtn.click();
        waitForCondition().until(ExpectedConditions.textToBePresentInElement(wtForVisaReaSelChk,"Check if you need a UK visa"));
    }

}
