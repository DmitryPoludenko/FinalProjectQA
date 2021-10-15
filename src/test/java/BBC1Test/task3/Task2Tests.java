package BBC1Test.task3;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Task2Tests extends BaseTest{
    private static final String QUESTION = "I want to ride my bicycle,\nI want to ride my bike.";
    private static final String NAME = "Queen";
    private static final String EMAIL = "queen";
    private static final int ONE_ERROR_MESSAGE = 1;
    private static final int TWO_ERROR_MESSAGES = 2;
    private static final int THREE_ERROR_MESSAGES = 3;
    private static final int FOUR_ERROR_MESSAGES = 4;


    @Test
    public void checkFieldsCanNotBeBlankWithCountsOfErrors()  {
        getHomePage().clickOnNewsButton();
        getHomePage().waitForPageLoadComplete(30);
        if (getNewsPage().checkPopUpWindow()){
            getNewsPage().clickOnClosePopUpButton();
        }
        getNewsPage().clickOnCoronaButton();
        getCoronaNewsPage().clickOnYourCoronaStoriesButton();
        getCoronaNewsPage().clickOnQuestionsButton();

        getYourQuestionsPage().typeInQuestionField(QUESTION);
        getYourQuestionsPage().typeInEmailField(EMAIL);
        getYourQuestionsPage().clickOnAcceptCheckbox();
        getYourQuestionsPage().clickOnSubmitButton();

        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), ONE_ERROR_MESSAGE);
        //getDriver().navigate().refresh();

    }





}
