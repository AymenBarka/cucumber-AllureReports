package com.e2eTest.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.Setup;

public class LoginPage {
	public ConfigFileReader configFileReader;
	public LoginPage loginPage;

	/* Retrieve Element */

	

     @FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
 	public  WebElement email ; 
     @FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
  	public  WebElement password ; 
     @FindBy(how = How.XPATH, using = "//div[@class='ui fluid large blue submit button']")
   	public  WebElement btnLogin ; 

     @FindBy(how = How.XPATH, using = "//div[@class='ui negative message']")
   	public  WebElement errorMsg ;
     
     
	public LoginPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	
}
