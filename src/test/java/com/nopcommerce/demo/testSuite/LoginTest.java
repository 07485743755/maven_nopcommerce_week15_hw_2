package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.customListeners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.retryAnalyzer.RetryAnalyzer;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        homePage=new HomePage();
        loginPage=new LoginPage();
        softAssert=new SoftAssert();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToLoginPage() {

        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test(groups = {"smoke","regression"},dataProvider = "credentials",dataProviderClass = TestData.class)
    public void verifyUserGetErrorMessageWithInValidCredentials(String username,String domain) throws InterruptedException {

        homePage.clickOnLoginLink();
        Thread.sleep(1000);
        loginPage.enterEmailId(username,domain);
        loginPage.enterPassword("j23453");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage=loginPage.getErrorMessage();
        softAssert.assertEquals(expectedErrorMessage,actualErrorMessage);
        softAssert.assertAll();

    }

    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserShouldLoggedSuccessfullyWithValidCredentials() throws InterruptedException {

        homePage.clickOnLoginLink();
        Thread.sleep(1000);
        loginPage.enterEmailId("alinaSalvator","@gmail.com");
        loginPage.enterPassword("A12345");
        loginPage.clickOnLoginButton();
        String expectedLoginSuccessText="Log out";
        String actualLoginSuccessText=homePage.getTextFromLogoutButton();
        softAssert.assertEquals(expectedLoginSuccessText,actualLoginSuccessText);
        softAssert.assertAll();

    }

}
