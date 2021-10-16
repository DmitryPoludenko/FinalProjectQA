package BBC.task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'primary__story')]//h3[contains(@class, 'promo-heading')]")
    private WebElement headTitle;

    @FindBy(xpath = "//div[contains(@class, 'top-stories__secondary-item')]//h3[contains(@class, 'heading__title')]")
    private List<WebElement> mainTitles;

    @FindBy(xpath = "//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")
    private WebElement coronaButton;

    @FindBy(xpath = "//div[@class='tp-iframe-wrapper tp-active']")
    private WebElement popUpWindow;

    @FindBy(xpath = "//button[@class='tp-close tp-active']")
    private WebElement closePopUpButton;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadTitleText() {
        return headTitle.getText();
    }

    public List<WebElement> getHeadSecondaryTitlesList() {
        return mainTitles;
    }

    public void clickOnCoronaButton() {
        coronaButton.click();
    }

    public WebElement getPopUpWindow (){
        return popUpWindow;
    }

    public void clickOnClosePopUpButton(){
        closePopUpButton.click();
    }

}
