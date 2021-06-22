package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    private static final Logger log= LogManager.getLogger(HomePage.class.getName());

    String emailId;
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerPageTitleText;
    @FindBy(id = "FirstName")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;
    @FindBy(id = "Password")
    WebElement passwordField;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;
    @FindBy(id = "register-button")
    WebElement registerButton;
    @FindBy(id = "FirstName-error")
    WebElement firstNameErrorMessage;
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationSuccessMessage;



    public String GetTitleTextFromRegisterPage(){
        Reporter.log("Getting text from : "+registerPageTitleText.toString()+"<br>");
        log.info("Getting text from : "+registerPageTitleText.toString());
        return getTextFromElement(registerPageTitleText);
    }

    public void enterFirstName(String firstName){
        Reporter.log("Send text : "+firstName+" to "+firstNameField.toString()+"<br>");
        sendTextToElement(firstNameField,firstName);
        log.info("Send text : "+firstName+" to "+firstNameField.toString());
    }

    public void enterLastName(String lastName){
        Reporter.log("Send text : "+lastName+" to "+lastNameField.toString()+"<br>");
        sendTextToElement(lastNameField,lastName);
        log.info("send text : "+lastName+" to "+lastNameField.toString());
    }

    public void enterEmailId(String userName,String domain){

        emailId=userName+generateRandomNumber()+domain;

        Reporter.log("Send text : "+emailId+" to "+emailField.toString()+"<br>");
        sendTextToElement(emailField,emailId);
        log.info("Send text : "+userName+generateRandomNumber()+domain+" to "+emailField.toString());
    }

    public void enterPassword(String password){
        Reporter.log("Send text : "+password+" to "+passwordField.toString()+"<br>");
        sendTextToElement(passwordField,password);
        log.info("Send text : "+password+" to "+passwordField.toString());
    }
    public void enterConfirmationPassword(String confirmationPassword){
        Reporter.log("Send text : "+confirmationPassword+" to "+confirmPasswordField.toString()+"<br>");
        sendTextToElement(confirmPasswordField,confirmationPassword);
        log.info("Send text : "+confirmationPassword+" to "+confirmPasswordField.toString());
    }
    public void clickOnRegisterButton(){
        Reporter.log("Clicking on : "+registerButton.toString()+"<br>");
        clickOnElement(registerButton);
        log.info("Clicking on : "+registerButton.toString());
    }
    public String getErrorMessageFromFirstNameField(){
        Reporter.log("Getting error message from : "+firstNameErrorMessage.toString()+"<br>");
        log.info("Getting error message from : "+firstNameErrorMessage.toString());
        return getTextFromElement(firstNameErrorMessage);
    }
    public String getRegistrationSuccessMessage(){
        Reporter.log("Getting registration success message From : "+registrationSuccessMessage.toString()+"<br>");
        log.info("Getting registration success message From : "+registrationSuccessMessage.toString());
        return getTextFromElement(registrationSuccessMessage);
    }
}
