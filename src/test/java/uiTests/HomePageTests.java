package uiTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ui.HomePage;
import ui.WebDriverHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTests {
    List<String> expectedMenuItems = new ArrayList<>(Arrays.asList("HOME", "TRADING", "PLATFORMS", "RESEARCH & EDUCATION", "PROMOTIONS", "ABOUT US", "PARTNERSHIPS"));

    @AfterMethod
    public static void afterMethod() {
        WebDriverHandler.closeBrowser();
    }

    @Test
    public void homePageSmokeTest() {
        HomePage HomePagePg = new HomePage();
        HomePagePg.open();
        HomePagePg.waitForCookiesToBeDisplayed();
        HomePagePg.clickAcceptCookies();
        assertTrue(HomePagePg.isLogoDisplayed(), "Logo wasn't displayed");
        assertTrue(HomePagePg.isDisplayedOpenAccountBtn(), "Open Account button wasn't displayed");
        assertTrue(HomePagePg.isDisplayedDemoAccountBtn(), "Demo Account button wasn't displayed");
        assertEquals(HomePagePg.foundNavListItems(),expectedMenuItems, "Header Menu naming is wrong");
        }

}
