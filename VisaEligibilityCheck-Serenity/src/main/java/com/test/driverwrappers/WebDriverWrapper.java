package com.test.driverwrappers;

import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class WebDriverWrapper extends PageObject {

	@Managed
	WebDriver driver;



	public void clickByJSexecutor(WebElementFacadeWrapper element) {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].focus;", element.getWebElement());
			jsExecutor.executeScript("arguments[0].click();", element.getWebElement());
		} catch (Exception err) {
			System.out.println(err.getMessage());

		}
	}

	public WebElementFacade findElement(WebElementFacade eleemnt ) {
	((JavascriptExecutor)driver).executeScript("arguments[0].focus", eleemnt.getElement());
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'})", eleemnt.getElement());
	/*((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", retElement.getWebElement());
	*/
	String colour[] = {"red","red","yellow","blue","grey","yellow","yellow","yellow","yellow","yellow","green"};

	for(String a:colour){
	((JavascriptExecutor)driver).executeScript("arguments[0].style.border='1.5px solid "+a+"'", eleemnt.getElement());
	}
	return (WebElementFacade) eleemnt.getElement();
	
}
	}

