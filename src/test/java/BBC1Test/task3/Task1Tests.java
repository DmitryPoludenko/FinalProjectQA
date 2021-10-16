package BBC1Test.task3;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class Task1Tests extends BaseTest {
    private static final String HEAD_TITLE = "Major Taliban row at presidential palace - sources";

    @Test
    public void ChecksTheNameOfTheHeadlineArticle() {


        getHomePage().clickOnNewsButton();
        assertTrue(getNewsPage().getHeadTitleText().contains(HEAD_TITLE));
    }

    @Test
    public void ChecksSecondaryArticleTitles(){

        List<String> titlesList = new ArrayList<>();
        titlesList.add("California governor beats bid to oust him - US media");
        titlesList.add("North Korea fires ballistic missiles, says South");
        titlesList.add("Russian elections: How democratic are they?");
        titlesList.add("Amateur astronauts set for orbital spaceflight");
        titlesList.add("Chinese court dismisses landmark #MeToo case");

        getHomePage().clickOnNewsButton();

        int count = 0;
        for (String title : titlesList){
            for(WebElement element : getNewsPage().getHeadSecondaryTitlesList()){
                if(element.getText().contains(title)){
                    count++;
                }
            }
        }
        assertEquals(getNewsPage().getHeadSecondaryTitlesList().size(), count);
    }
}
