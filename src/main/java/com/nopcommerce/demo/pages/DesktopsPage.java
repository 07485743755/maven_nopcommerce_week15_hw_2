package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {

    private static final Logger log= LogManager.getLogger(DesktopsPage.class.getName());
    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement desktopsPageTitle;

    public String getDesktopsPageTitle(){
        Reporter.log("Getting text from : "+desktopsPageTitle.toString()+"<br>");
        log.info("Getting text from : "+desktopsPageTitle.toString());
        return getTextFromElement(desktopsPageTitle);
    }
}
