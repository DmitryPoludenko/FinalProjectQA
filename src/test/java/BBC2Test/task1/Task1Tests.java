package BBC2Test.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Task1Tests {

    private WebDriver driver;
    private static final String URL = "https://www.bbc.com/";


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
    public void ChecksTheNameOfTheHeadlineArticle() {

        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();

        WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'primary__story')]//h3[contains(@class, 'promo-heading')]"));
        String text = webElement.getText();
        Assert.assertTrue(text.contains("Major Taliban row at presidential palace - sources"));
    }

    @Test
    public void ChecksSecondaryArticleTitles() {

        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class, 'top-stories__secondary-item')]//h3[contains(@class, 'heading__title')]"));
        List<String> titlesList = new ArrayList<>();
        titlesList.add("California governor beats bid to oust him - US media");
        titlesList.add("North Korea fires ballistic missiles, says South");
        titlesList.add("Russian elections: How democratic are they?");
        titlesList.add("Amateur astronauts set for orbital spaceflight");
        titlesList.add("Chinese court dismisses landmark #MeToo case");

        int count = 0;
        for (String tempString : titlesList) {
            for (WebElement element : elements) {
                if (element.getText().contains(tempString)) {
                    count++;
                    Assert.assertTrue(element.getText().contains(tempString));
                }
            }
        }
        Assert.assertEquals(elements.size(), count);
    }


    @Test
    public void checkImpossibilityFindingByArticleName() {
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        String headArticle = driver.findElement(By.xpath("//a[contains(@class,' gel-paragon-bold')]")).getText();
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys(headArticle, Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ssrcss-1wctgia-Stack e1y4nx260']"))
                .getText().contains("Sorry"));
    }

    @Test
    public void checkStoredMainNewsArticleName() {
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//a[contains(@class,' gel-paragon-bold')]")).click();
        String headArticle = "Afghanistan: US-Taliban deal hastened Afghan collapse, defence officials say";
        driver.findElement(By.xpath("//div[@class='ssrcss-xx6wca-GlobalNavigationSide eki2hvo16']")).click();
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(headArticle, Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ssrcss-som5se-PromoContent e1f5wbog7']"))
                .getText().contains(headArticle));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
