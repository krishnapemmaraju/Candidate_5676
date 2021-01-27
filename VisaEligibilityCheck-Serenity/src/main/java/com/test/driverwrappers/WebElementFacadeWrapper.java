package com.test.driverwrappers;

import net.serenitybdd.core.pages.WebElementFacade;

public class WebElementFacadeWrapper {
	
	public WebElementFacade element;
	
	public  WebElementFacadeWrapper(WebElementFacade element) {
		 this.element = element;
	}
	
	public boolean isSelected() {
		return element.isSelected();
	}

	public boolean isEnabled() {
		return element.isEnabled();
	}

	public boolean isDisplayed() {
		// edited by pavan since it stop execution
	//	try{ 
		return element.isDisplayed();		
	//	}
	//	catch(Exception e){
	//		 e.printStackTrace();
	//		return false;
	//	}
	}

	public String getText() {
		return element.getText();
	}

	public String getTagName() {
		return element.getTagName();
	}

	public String getCssValue(String arg0) {
		return element.getCssValue(arg0);
	}

	public String getAttribute(String attribute) {
		return element.getAttribute(attribute);
	}

	public void submit() {
		element.submit();
	}

	@Deprecated
	public void sendKeys(CharSequence... key) {
		try{
		element.sendKeys(key);
		String attribute = getAttribute("value");
		if(attribute.equals(key)){
		}else{
			System.out.println("value is not same "+ key);
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	

/**
 * 
 * @param key
 */
	public void type(CharSequence... key) {
		try{
			element.sendKeys(key);
			String attribute = getAttribute("value");
			if(attribute.equals(key)){
			}else{
				System.out.println("value is not same "+ key);
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
	

	/**
	 * 
	 * @author 
	 * @param key
	 */
	public void setValue(CharSequence... key) {
		try{
			element.clear();
			element.sendKeys(key);
			String attribute = getAttribute("value");
			if(attribute.equals(key)){
			}else{
				System.out.println("value is not same "+ key);
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
	
	
	public void click() {
		try{
		element.click();
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
			
		}
	}

	public void clear() {
		element.clear();
	}

	public boolean isAvailableForAction() {
		if (isDisplayed() && isEnabled())
			return true;
		   return false;
	}

	public boolean verifyAttributeEquals(String attribute, String value) {
		if (element.getAttribute(attribute).equals(value))
			return true;
		return false;
	}

	public WebElementFacadeWrapper findElement(String findByType, String locator) {
		WebElementFacadeWrapper retElement = new WebElementFacadeWrapper(element.find(FindBy.seByMechanism(findByType, locator)));
		return retElement;
	}

	public boolean verifyAttributeContains(String attribute, String value) {
		if (element.getAttribute(attribute).contains(value))
			return true;
		return false;
	}

	public boolean verifyTextEquals(String value) {
		if (element.getText().equals(value))
			return true;
		return false;
	}

	
	
	
	public boolean verifyTextContains(String value) {
		if (element.getText().contains(value))
			return true;
		return false;
	}

	public WebElementFacade getWebElement() {
		return element;
	}

}
