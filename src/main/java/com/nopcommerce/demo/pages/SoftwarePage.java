package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SoftwarePage extends Utility {

    private static final Logger log= LogManager.getLogger(SoftwarePage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Software')]")
    WebElement softwarePageTitle;

    public String getSoftWarePageTitleText(){

        Reporter.log("Getting text from : "+softwarePageTitle.toString()+"<br>");
        log.info("Getting text from : "+softwarePageTitle.toString());
        return getTextFromElement(softwarePageTitle);
    }
}
