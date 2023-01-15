package ui;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    private static final String url = "https://www.xm.com";
    @FindBy(css = "#navigation-collapse .logo")
    private WebElement logo;
    @FindBy(css = "#cookieModal .gtm-acceptDefaultCookieFirstVisit")
    private WebElement acceptCookies;
    @FindBy(css = "#cookieModal")
    private WebElement cookies;
    @FindBy(xpath = "//div[@class='buttons-wrap']//div[contains(@class,'col-sm-6 hidden-xs')]//*[contains(text(),'Open a Demo Account')]")
    private WebElement demoAccountBtn;
    @FindBy(xpath = "//div[@class='buttons-wrap']//div[contains(@class,'col-sm-6 hidden-xs')]//*[contains(text(),' OPEN AN ACCOUNT ')]")
    private WebElement openAccountBtn;

    //try locator ".nav-logo > li" (or similar xpath) :)
    @FindBy(xpath = "//ul[@id=('main-nav') and @class=('nav navbar-nav navbar-right default nav-logo hidden-xs hidden-sm')]/li")
    List<WebElement> navListItems; //= WebDriverHandler.getDriver().findElements(By.xpath("//ul[@id=('main-nav') and @class=('nav navbar-nav navbar-right default nav-logo hidden-xs hidden-sm')]/li"));

    public void open() {
        WebDriverHandler.openPage(url);
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void waitForCookiesToBeDisplayed() {
        WebDriverHandler.getWait().until(ExpectedConditions.visibilityOf(cookies));
    }

    public void clickAcceptCookies() {
        acceptCookies.click();
    }

    public boolean isDisplayedDemoAccountBtn() {
        return demoAccountBtn.isDisplayed();
    }

    public boolean isDisplayedOpenAccountBtn() {
        return openAccountBtn.isDisplayed();
    }

    //it works, but it's not optimal :) there's an assertion that helps you verify if two objects are equal, including collections -
    //so if you extract texts from these elements, it'll be easier!
    public boolean foundNavListItems() {
        List<String> expectedMenuItems = new ArrayList<>(Arrays.asList("Home", "Trading", "Platforms", "Research & Education", "Promotions", "About Us", "Partnerships"));
        List<String> actualMenuItems = new ArrayList<>();
        for (WebElement listItem : navListItems) {
            actualMenuItems.add(listItem.getText());
        }
        boolean flag = true;
        for (int i = 0; i < expectedMenuItems.size(); i++) {
            if (!actualMenuItems.get(i).equalsIgnoreCase(expectedMenuItems.get(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
