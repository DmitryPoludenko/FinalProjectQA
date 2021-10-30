package BBC1Test.task3;

import static org.testng.Assert.*;

import io.cucumber.java.an.E;
import org.testng.annotations.Test;

public class Task2Tests extends BaseTest {
    private static final String EMPTY_QUESTION = "";
    private static final String QUESTION = "@I want to ride my bicycle,\nI want to ride my bike.@";
    private static final String EMPTY_NAME = "";
    private static final String NAME = "``Bicycle Race``";
    private static final String EMPTY_EMAIL = "";
    private static final String EMAIL = "#Queen";
    private static final boolean CHECKBOX_ON = true;
    private static final boolean CHECKBOX_OFF = false;

    private static final int ONE_ERROR_MESSAGE = 1;
    private static final int TWO_ERROR_MESSAGES = 2;
    private static final int THREE_ERROR_MESSAGES = 3;
    private static final int FOUR_ERROR_MESSAGES = 4;

    @Test
    public void checkFieldsCanNotBeBlankWithCountsOfErrors() {
        getHomePage().clickOnNewsButton();
        getNewsPage().waitForLoadAndClosePopUpWindow();
        getNewsPage().clickOnCoronaButton();
        getCoronaNewsPage().clickOnYourCoronaStoriesButton();
        getCoronaNewsPage().clickOnQuestionsButton();

        getYourQuestionsPage().clickOnSubmitButton();
        getYourQuestionsPage().waitForPageLoadComplete(10, getYourQuestionsPage().getErrorMessage());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), FOUR_ERROR_MESSAGES);

        getYourQuestionsPage().submitYourQuestion(QUESTION, NAME, EMAIL, CHECKBOX_OFF);
        errorWaiter(ONE_ERROR_MESSAGE);

        getYourQuestionsPage().waitForPageLoadComplete(10, getYourQuestionsPage().getErrorMessage());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), ONE_ERROR_MESSAGE);


        getYourQuestionsPage().refreshThePage();
        getYourQuestionsPage().submitYourQuestion(QUESTION, EMPTY_NAME, EMPTY_EMAIL, CHECKBOX_OFF);
        errorWaiter(THREE_ERROR_MESSAGES);
        getYourQuestionsPage().waitForPageLoadComplete(10, getYourQuestionsPage().getErrorMessage());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), THREE_ERROR_MESSAGES);

        getYourQuestionsPage().refreshThePage();
        getYourQuestionsPage().submitYourQuestion(EMPTY_QUESTION, NAME, EMPTY_EMAIL, CHECKBOX_ON);
        errorWaiter(TWO_ERROR_MESSAGES);
        getYourQuestionsPage().waitForPageLoadComplete(10, getYourQuestionsPage().getErrorMessage());
        assertTrue(getYourQuestionsPage().checkErrorMessage());
        assertEquals(getYourQuestionsPage().countNumberOfErrorMessages(), TWO_ERROR_MESSAGES);
    }

    private void errorWaiter(int numberOfErrors) {
        while (getYourQuestionsPage().countNumberOfErrorMessages() != numberOfErrors) {
            continue;
        }
    }

}
