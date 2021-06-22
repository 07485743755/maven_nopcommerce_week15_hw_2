package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.NoteBooksPage;
import com.nopcommerce.demo.pages.SoftwarePage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ComputerTest extends TestBase {


    HomePage homePage;
    DesktopsPage desktopsPage;
    SoftAssert softAssert;
    NoteBooksPage noteBooksPage;
    SoftwarePage softwarePage;
    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        homePage=new HomePage();
        desktopsPage=new DesktopsPage();
        noteBooksPage=new NoteBooksPage();
        softwarePage=new SoftwarePage();
        softAssert=new SoftAssert();

    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        homePage.mouseHoverOnComputersTab();
        homePage.selectFromComputersDropDown("Desktops");
        String expectedDesktopsPageTitle="Desktops";
        String actualDesktopsPageTitle=desktopsPage.getDesktopsPageTitle();
        softAssert.assertEquals(expectedDesktopsPageTitle,actualDesktopsPageTitle);
        softAssert.assertAll();
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToNotebooksPageSuccessfully(){

        homePage.mouseHoverOnComputersTab();
        homePage.selectFromComputersDropDown("Notebooks");
        String expectedDesktopsPageTitle="Notebooks";
        String actualDesktopsPageTitle=noteBooksPage.getPageTitleFromNotebooksPage();
        softAssert.assertEquals(expectedDesktopsPageTitle,actualDesktopsPageTitle);
        softAssert.assertAll();

    }
    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToSoftwarePageSuccessfully(){

        homePage.mouseHoverOnComputersTab();
        homePage.selectFromComputersDropDown("Software");
        String expectedSoftwarePageTitle="Software";
        String actualSoftwarePageTitle=softwarePage.getSoftWarePageTitleText();
        softAssert.assertEquals(expectedSoftwarePageTitle,actualSoftwarePageTitle);
        softAssert.assertAll();

    }
}
