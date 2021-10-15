package BBC.task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronaNewsPage extends BasePage{

    public CoronaNewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")
    private WebElement yourCoronaStoriesButton;

    @FindBy(xpath = "//a[@href='/news/52143212']")
    private WebElement questionsButton;

    public void clickOnYourCoronaStoriesButton(){
        yourCoronaStoriesButton.click();
    }
    public void clickOnQuestionsButton(){
        questionsButton.click();
    }
}
