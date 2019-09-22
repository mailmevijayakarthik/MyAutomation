package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.BaseClass;

public class Homepage extends BaseClass{
	
	
	public Homepage(WebDriver driver) {
	 super();
	 driver=this.driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	private WebElement Searchfield;
	
	@FindBy(xpath="//input[@value='Google Search']")
	private WebElement BtnGoogleSearch;
	
	@FindBy(xpath="//input[@id='gbqfbb']")
	private WebElement BtnFeelingLucky;

	

	public WebElement getSearchfield() {
		return Searchfield;
	}

	public WebElement getBtnGoogleSearch() {
		return BtnGoogleSearch;
	}

	public WebElement getBtnFeelingLucky() {
		return BtnFeelingLucky;
	}
	
	
}
