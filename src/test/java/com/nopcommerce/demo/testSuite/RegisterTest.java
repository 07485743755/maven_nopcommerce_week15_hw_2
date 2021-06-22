package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest extends TestBase {


    HomePage homePage;
    RegisterPage registerPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){

       homePage=new HomePage();
       registerPage=new RegisterPage();
       softAssert=new SoftAssert();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

        homePage.clickOnRegisterLink();
        String expectedRegisterPageTitleText="Register";
        String actualRegisterPageTitleText=registerPage.GetTitleTextFromRegisterPage();
        softAssert.assertEquals(expectedRegisterPageTitleText,actualRegisterPageTitleText);
        softAssert.assertAll();
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserGetErrorMessageWhenRegistrationWithMandatoryFieldFirstNameEmpty(){

        homePage.clickOnRegisterLink();
        registerPage.enterLastName("Salvator");
        registerPage.enterEmailId("alina","@gmail.com");
        registerPage.enterPassword("Alina12345");
        registerPage.enterConfirmationPassword("Alina12345");
        registerPage.clickOnRegisterButton();
        String expectedErrorMessage="First name is required.";
        String actualErrorMessage=registerPage.getErrorMessageFromFirstNameField();
        softAssert.assertEquals(expectedErrorMessage,actualErrorMessage);
        softAssert.assertAll();

    }

    @Test(groups = {"regression"},priority = 0)
    public void verifyUserShouldRegistrationSuccessfullyWithFillAllMandatoryField() throws InterruptedException {

        homePage.clickOnRegisterLink();
        Thread.sleep(1000);
        registerPage.enterFirstName("Alina");
        registerPage.enterLastName("Salvator");
        registerPage.enterEmailId("alinaSalvator","@gmail.com");
        Thread.sleep(1000);
        registerPage.enterPassword("A12345");
        registerPage.enterConfirmationPassword("A12345");
        registerPage.clickOnRegisterButton();
        String expectedRegistrationSuccessMessage="Your registration completed";
        String actualRegistrationSuccessMessage=registerPage.getRegistrationSuccessMessage();
        softAssert.assertEquals(expectedRegistrationSuccessMessage,actualRegistrationSuccessMessage);
        softAssert.assertAll();

    }
}
