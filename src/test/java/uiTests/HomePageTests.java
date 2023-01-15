package uiTests;

import org.openqa.selenium.support.PageFactory;
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
        HomePage HomePagePg = PageFactory.initElements(WebDriverHandler.getDriver(),HomePage.class);
        HomePagePg.open();
        HomePagePg.waitForCookiesToBeDisplayed();
        HomePagePg.clickAcceptCookies();
        assertTrue(HomePagePg.isLogoDisplayed(), "Logo wasn't displayed");
        assertTrue(HomePagePg.isDisplayedOpenAccountBtn(), "Open Account button wasn't displayed");
        assertTrue(HomePagePg.isDisplayedDemoAccountBtn(), "Demo Account button wasn't displayed");
        assertTrue(HomePagePg.foundNavListItems(), "Header Menu naming is wrong");
    }
}
