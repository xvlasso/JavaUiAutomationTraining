package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class HomePageSelenide {

    private static final String URL = "";

    private final static SelenideElement logo = $("#navigation-collapse .logo");
    private final static SelenideElement acceptCookies = $("#cookieModal .gtm-acceptDefaultCookieFirstVisit");
    private final static SelenideElement cookies = $("#cookieModal");
    private final static SelenideElement demoAccountBtn = $x("//div[@class='buttons-wrap']//div[contains(@class,'col-sm-6 hidden-xs')]//*[contains(text(),'Open a Demo Account')]");
    private final static SelenideElement openAccountBtn = $x("//div[@class='buttons-wrap']//div[contains(@class,'col-sm-6 hidden-xs')]//*[contains(text(),' OPEN AN ACCOUNT ')]");
    private final static ElementsCollection navListItems = $$x("//ul[contains(@class,'nav-logo')]/li");
    public void open() {
        WebDriverHandlerSelenide.openPage(URL);
    }
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
    public void waitForCookiesToBeDisplayed() {
        cookies.shouldBe(Condition.visible);
    }
    public void clickAcceptCookies() {
        acceptCookies.click();
    }
    public boolean isDisplayedDemoAccountBtn(){
        return demoAccountBtn.isDisplayed();
    }
    public boolean isDisplayedOpenAccountBtn(){
        return openAccountBtn.isDisplayed();
    }
     public List<String> getListOfNavListItems(){
         return navListItems.texts();
     }
}
