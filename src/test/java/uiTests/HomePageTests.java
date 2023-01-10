package uiTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ui.HomePage;
import ui.WebDriverHandler;

import static org.testng.Assert.assertTrue;

public class HomePageTests {
    @AfterMethod
    public static void afterMethod() {
        WebDriverHandler.closeBrowser();
    }

    @Test
    public void homePageSmokeTest() {
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.waitForCookiesToBeDisplayed();
        homePage.clickAcceptCookies();
        assertTrue(homePage.isLogoDisplayed(), "Logo wasn't displayed");
        assertTrue(homePage.isDisplayedOpenAccountBtn(), "Open Account button wasn't displayed");
        assertTrue(homePage.isDisplayedDemoAccountBtn(), "Demo Account button wasn't displayed");
        assertTrue(homePage.foundNavListItems(), "Navigation Menu naming is wrong");
    }
}
