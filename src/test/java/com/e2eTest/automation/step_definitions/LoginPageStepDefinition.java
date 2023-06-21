package com.e2eTest.automation.step_definitions;

import java.time.Duration;

import com.e2eTest.automation.page_objects.LoginPage;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.SelectFromListUtils;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Setup;
import com.e2eTest.automation.utils.Validations;
import com.e2eTest.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition {
	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
	public Validations validation;
	public LoginPage loginPage;
    public Wait wait;
	public LoginPageStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
		loginPage = new LoginPage();
		wait = new Wait(Setup.getDriver());

	}

	@Given("I am on the login page")
	public void iAmOnTheLoginPage() {
		utils.get(configFileReader.getProperties("home.url"));
	}

	@When("I enter the email and password")
	public void iEnterTheEmailAndPassword() {
		utils.writeText(loginPage.email, configFileReader.getProperties("email"));
		utils.writeText(loginPage.password, configFileReader.getProperties("password"));

	}

	@When("I click the login button")
	public void iClickTheLoginButton() {
		utils.click(loginPage.btnLogin);

	}

	@Then("Page Title should be Cogemento")
	public void pageTitleShouldBeCogemento() {
		validation.assertEqual(utils.getTitle(), "Cogmento CRM");
	}

	

	@When("I enter the email {string} and password {string}")
	public void iEnterTheEmailAndPassword(String email, String password) {
		utils.writeText(loginPage.email,email);
		utils.writeText(loginPage.password,password);

	}
	@Then("I should see an error message")
	public void iShouldSeeAnErrorMessage() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20),loginPage.errorMsg,configFileReader.getProperties("error"));

		validation.assertTrue(loginPage.errorMsg,configFileReader.getProperties("error"));

	}

}

