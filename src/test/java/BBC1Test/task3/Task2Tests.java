package BBC1Test.task3;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class Task2Tests extends BaseTest {
    private static final String QUESTION = "@I want to ride my bicycle,\nI want to ride my bike.@";
    private static final String NAME = "``Bicycle Race``";
    private static final String EMAIL = "#Queen";
    private static final int ONE_ERROR_MESSAGE = 1;
    private static final int TWO_ERROR_MESSAGES = 2;
    private static final int THREE_ERROR_MESSAGES = 3;
    private static final int FOUR_ERROR_MESSAGES = 4;

    @Test
    public void checkFieldsCanNotBeBlankWithCountsOfErrors() throws InterruptedException {
        getHomePage().clickOnNewsButton();
        getHomePage().waitVisibilityOfElement(5, getNewsPage().getPopUpWindow());
        getNewsPage().clickOnClosePopUpButton();
        getNewsPage().clickOnCoronaButton();
        getCoronaNewsPage().clickOnYourCoronaStoriesButton();
        getCoronaNewsPage().clickOnQuestionsButton();

        getYourQuestionsPage().clickOnSubmitButton();
        getYourQuestionsPage().waitForPageLoadComplete(10, getYourQuestionsPage().getErrorMessage());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), FOUR_ERROR_MESSAGES);

        getYourQuestionsPage().typeInQuestionField(QUESTION);
        getYourQuestionsPage().typeInEmailField(EMAIL);
        getYourQuestionsPage().clickOnAcceptCheckbox();
        getYourQuestionsPage().clickOnSubmitButton();
        //Thread.sleep(500);
        getYourQuestionsPage().waitForLoad(getDriver());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), ONE_ERROR_MESSAGE);

        getDriver().navigate().refresh();

        getYourQuestionsPage().typeInNameField(NAME);
        getYourQuestionsPage().clickOnAcceptCheckbox();
        getYourQuestionsPage().clickOnSubmitButton();
        getYourQuestionsPage().waitForPageLoadComplete(10, getYourQuestionsPage().getErrorMessage());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), TWO_ERROR_MESSAGES);

        getDriver().navigate().refresh();

        getYourQuestionsPage().typeInQuestionField(QUESTION);
        getYourQuestionsPage().clickOnSubmitButton();
        getYourQuestionsPage().waitForPageLoadComplete(10, getYourQuestionsPage().getErrorMessage());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), THREE_ERROR_MESSAGES);
    }

}
