package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    private static final Logger log= LogManager.getLogger(HomePage.class.getName());

    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement registerLink;
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutLink;
    @FindBy(xpath = "(//a[contains(text(),'Computers ')])[1]")
    WebElement computersTab;
    @FindBys({@FindBy(xpath = "(//ul[@class='sublist first-level'])[1]//a")})
    List<WebElement> computersTabDropDown;


    public void clickOnLoginLink() {
        Reporter.log("Clicking on login link : " + loginLink.toString() + "<br>");
        clickOnElement(loginLink);
        log.info("Clicking on login link : " + loginLink.toString());
    }

    public void clickOnRegisterLink() {
        Reporter.log("Clicking on login link : " + registerLink.toString() + "<br>");
        clickOnElement(registerLink);
        log.info("Clicking on login link : " + registerLink.toString());
    }

    public String getTextFromLogoutButton(){
        Reporter.log("Getting text from : "+logoutLink.toString()+"<br>");
        log.info("Getting text from : "+logoutLink.toString());
        return getTextFromElement(logoutLink);
    }

    public void mouseHoverOnComputersTab(){
        Reporter.log("Mouse hover on : "+computersTab.toString()+"<br>");
        mouseHoverToElement(computersTab);
        log.info("Mouse hover on : "+computersTab.toString());
    }

    public void selectFromComputersDropDown(String menu){

        for (WebElement element:computersTabDropDown){
            Reporter.log("Getting text from : "+element.toString()+" compare it with : "+menu+"<br>");
            log.info("Getting text from : "+element.toString()+" compare it with : "+menu);
            if (element.getText().equalsIgnoreCase(menu)){
                Reporter.log("Mouse hover and click on element : "+element.toString()+"<br>");
                log.info("Mouse hover and click on element : "+element.toString());
                mouseHoverToElementAndClick(element);
                break;
            }
        }

    }
}
