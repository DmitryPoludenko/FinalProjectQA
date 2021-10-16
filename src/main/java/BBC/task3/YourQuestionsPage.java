package BBC.task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YourQuestionsPage extends BasePage {
    public YourQuestionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@aria-label='What questions would you like us to answer?']")
    private WebElement questionField;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement acceptCheckbox;

    @FindBy(xpath = "//button[text() = 'Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private List<WebElement> listOfErrorMessages;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement errorMessage;


    public void typeInQuestionField(final String message) {
        questionField.sendKeys(message);
    }

    public void typeInNameField(final String name) {
        nameField.sendKeys(name);
    }

    public void typeInEmailField(final String email) {
        emailField.sendKeys(email);
    }

    public void clickOnAcceptCheckbox() {
        acceptCheckbox.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public boolean checkErrorMessage() {
        return isElementPresented(listOfErrorMessages.get(0));
    }

    public int countNumberOfErrorMessages() {
        return listOfErrorMessages.size();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }


}
