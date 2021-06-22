package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class NoteBooksPage extends Utility {

    private static final Logger log= LogManager.getLogger(NoteBooksPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Notebooks')]")
    WebElement noteBooksPageTitle;

    public String getPageTitleFromNotebooksPage(){
        Reporter.log("Getting text from : "+noteBooksPageTitle.toString()+"<br>");
        log.info("Getting text from : "+noteBooksPageTitle.toString());
        return getTextFromElement(noteBooksPageTitle);
    }
}
