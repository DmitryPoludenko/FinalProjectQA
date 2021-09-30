package LoremIpsumTest.task1.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.util.Strings;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class TestsPart1 {

    private WebDriver driver;
    private static final String URL = "https://lipsum.com/";


    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    }

    @Test
    public void verifyThatTheWordCorrectlyAppears() {

        driver.findElement(By.xpath("//a[contains(@href, 'ru')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("ru"));
        WebElement webElement = driver.findElement(By.xpath("//p[contains(text(), 'рыба')]"));
        String text = webElement.getText();
        Assert.assertTrue(text.contains("рыба"));
    }

    public WebDriver getDriver() {
        return driver;
    }


    /*

    //a[contains(@href, 'ru')]

    IWebElement element = driver.FindElement(By.XPath("xpath"));
    // Replace “xpath” with correct xpath. This returns an IWebElement interface of the element found by Xpath.
    This interface can then be used to click the element or perform other actions (such as getting its text, checking visibility).
	element.Click() // Clicks the element
    string elementText = element.Text;
    // Assigns the text in the element (which is usually what you see on this element in your browser) to variable elementText
	Assert.AreEqual("text", elementText);
	// Checks that string “text” is equal to variable elementText, and throws exception if not. Use for checks that must succeed for the test to pass (i.e. the checks that are the purpose of the test).
     */

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
