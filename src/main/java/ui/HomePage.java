package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(xpath = "//ul[@id=('main-nav') and @class=('nav navbar-nav navbar-right default nav-logo hidden-xs hidden-sm')]/li")
    List<WebElement> navListItems; //= WebDriverHandler.getDriver().findElements(By.xpath("//ul[@id=('main-nav') and @class=('nav navbar-nav navbar-right default nav-logo hidden-xs hidden-sm')]/li"));


    public HomePage() {
        PageFactory.initElements(WebDriverHandler.getDriver(), this);
    }

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

    public boolean foundNavListItems() {
        int flag = 0;
        for (WebElement listItem : navListItems) {
            if (listItem.getText().trim().equalsIgnoreCase("Home")) {
                flag++;
            } else if (listItem.getText().trim().equalsIgnoreCase("Trading")) {
                flag++;
            } else if (listItem.getText().trim().equalsIgnoreCase("Platforms")) {
                flag++;
            } else if (listItem.getText().trim().equalsIgnoreCase("Research & Education")) {
                flag++;
            } else if (listItem.getText().trim().equalsIgnoreCase("Promotions")) {
                flag++;
            } else if (listItem.getText().trim().equalsIgnoreCase("About Us")) {
                flag++;
            } else if (listItem.getText().trim().equalsIgnoreCase("Partnerships")) {
                flag++;
            }
        }
        return flag == 7;
    }
}
