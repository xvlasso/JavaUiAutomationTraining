package uiTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ui.HomePageSelenide;
import ui.WebDriverHandlerSelenide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenideTests {
    List<String> expectedMenuItems = new ArrayList<>(Arrays.asList("HOME", "TRADING", "PLATFORMS", "RESEARCH & EDUCATION", "PROMOTIONS", "ABOUT US", "PARTNERSHIPS"));

    @AfterMethod
    public static void afterMethod(){
        WebDriverHandlerSelenide.closeBrowser();
    }

    @Test
    public void homePageSelenideTest(){
        HomePageSelenide homePageSelenide = new HomePageSelenide();
        homePageSelenide.open();
        homePageSelenide.waitForCookiesToBeDisplayed();
        homePageSelenide.clickAcceptCookies();
        assertTrue(homePageSelenide.isLogoDisplayed(),"Logo wasn't displayed");
        assertTrue(homePageSelenide.isDisplayedDemoAccountBtn(),"Demo Account button wasn't displayed");
        assertTrue(homePageSelenide.isDisplayedOpenAccountBtn(),"Open Account button wasn't displayed");
        assertEquals(homePageSelenide.getListOfNavListItems(),expectedMenuItems,"Header Menu naming is wrong");

    }

}
