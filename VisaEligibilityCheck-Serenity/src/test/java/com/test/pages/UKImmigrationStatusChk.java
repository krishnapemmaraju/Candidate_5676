package com.test.pages;

import com.serenity.test.implementation.GovUKFamilyVisaSelecCriteria;

import net.thucydides.core.annotations.Step;

public class UKImmigrationStatusChk {
	
	GovUKFamilyVisaSelecCriteria familyVisaImmgChk;
	
	@Step
	public void FamilyVisaUKImmigrationChk(String immgStatus) {
		familyVisaImmgChk.FamilyVisaUKImmigrationChk(immgStatus);
	}

}
