package com.test.pages;

import com.serenity.test.implementation.GovUKVisaNationAndReaSelecCriteria;

import net.thucydides.core.annotations.Step;

public class VisaChkNationAndReasonCriteriaPage {
	
	GovUKVisaNationAndReaSelecCriteria visaSelPage;
	
	@Step
	public void selectNationalityAndReason(String nationality,String reason) {
		visaSelPage.selectNationalityAndReason(nationality,reason);
	}
	
	
	public String validateOutcome() {
		return visaSelPage.validateOutcome();
	}
}
