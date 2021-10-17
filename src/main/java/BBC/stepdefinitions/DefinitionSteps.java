package BBC.stepdefinitions;

import BBC.manager.PageFactoryManager;
import BBC.pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks on the news button")
    public void userClicksOnTheNewsButton() {
        homePage.clickOnNewsButton();
    }

    @When("User gets the name of the head article")
    public String getTheNameOfHeadArticle() {
        newsPage = pageFactoryManager.getNewsPage();
        return newsPage.getHeadTitleText();
    }

    @Then("User checks that the name of head article equals {string}")
    public void userChecksThatTheNameOfHeadArticleEqualsHardCodeName(final String titleName) {
        assertEquals(titleName, getTheNameOfHeadArticle());
    }


    @When("User gets the names of the secondary head articles")
    public List<WebElement> getTheNamesOfTheSecondaryHeadArticles() {
        newsPage = pageFactoryManager.getNewsPage();
        return newsPage.getHeadSecondaryTitlesList();
    }

    @Then("User checks that the names of the secondary head articles equals hardcoded {string}")
    public void checkTheNamesOfTheSecondaryHeadArticles(final String tempString) {
        int count = 0;
        for (WebElement element : getTheNamesOfTheSecondaryHeadArticles()) {

            if (element.getText().contains(tempString)) {
                count++;
                assertTrue(element.getText().contains(tempString));
            }
            assertEquals(1,count);
        }
    }
}

