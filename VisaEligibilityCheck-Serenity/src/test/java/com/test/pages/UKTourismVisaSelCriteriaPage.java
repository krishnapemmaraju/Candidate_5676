package com.test.pages;

import com.serenity.test.implementation.GovUKTouristVisaSelecCriteria;
import net.thucydides.core.annotations.Step;

public class UKTourismVisaSelCriteriaPage {

    GovUKTouristVisaSelecCriteria touristUKVisaSelCriteria;

    @Step
    public void SelUKTouristVisaSelecCriteria(String selectCriteria){
        touristUKVisaSelCriteria.SelTourismVisaSelCriteria(selectCriteria);
    }

}
