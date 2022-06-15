package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class CreateContactConfirPage extends WebdriverUtility {
	
	WebDriver driver;
	public CreateContactConfirPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ConfirmartioText;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement DeletBtn;
	
	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement EditBtn;
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBTN;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getConfirmartioText() {
		return ConfirmartioText;
	}

	public WebElement getDeletBtn() {
		return DeletBtn;
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}
	
	public WebElement getCreateContactBTN() {
		return createContactBTN;
	}

	public void deletcContactPopUp(WebDriver driver, String PopupText)
	{
		swithToAlertWindowAndAccpect(driver, PopupText);
	}
	
	public String campaignconfirmation()
	{
		String message = ConfirmartioText.getText();
		return message;
		
	}
	
	
	
// public void CreateContactConfirPageMenu(WebDriver driver)
// {
//	 ConfirmartioText.getText();
//	 DeletBtn.click();
//	 EditBtn.click();
//	 createContactBTN.click();
// }
}
