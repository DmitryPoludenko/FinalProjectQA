package BBC.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, SECONDS);
    }

    public void waitForPageLoadComplete(long timeToWait, WebElement element) {
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }


    public Boolean isElementPresented(WebElement element) {
        boolean elementCondition = false;
        try {
            elementCondition = element.isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }


    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }
}
