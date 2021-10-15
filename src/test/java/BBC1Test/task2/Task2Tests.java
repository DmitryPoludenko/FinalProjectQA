package BBC1Test.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Task2Tests {

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

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testCheckingCanBeBlankField() {

        driver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        if (isElementPresented(By.xpath("//div[@class='tp-iframe-wrapper tp-active']"))) {
            driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();
        }
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='What questions would you like us to answer?']"))
                .sendKeys("iPhone 11");
        driver.findElement(By.xpath("//input[@aria-label='Name']"))
                .sendKeys("");
        driver.findElement(By.xpath("//input[@aria-label='Email address']"))
                .sendKeys("");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        Assert.assertTrue(isElementPresented(By.xpath("//div[@class='input-error-message']")));

        List<WebElement> warningsList = driver.findElements(By.xpath("//div[@class='input-error-message']"));
        Assert.assertEquals(warningsList.size(), 2);
    }

    @Test
    public void testCorrectlyTyping() {
        driver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        if (isElementPresented(By.xpath("//div[@class='tp-iframe-wrapper tp-active']"))) {
            driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();
        }
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();

        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//input[@aria-label='Email address']"))
                .sendKeys("someMail@mail.ua");
        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        Assert.assertFalse(isElementPresented(By.xpath("//div[contains(text(),'Email')]")));

    }

    @Test
    public void testCheckingCanBeBlankField2() {

        driver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        if (isElementPresented(By.xpath("//div[@class='tp-iframe-wrapper tp-active']"))) {
            driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();
        }
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();

        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='What questions would you like us to answer?']"))
                .sendKeys("!!!!@!!!");
        driver.findElement(By.xpath("//input[@aria-label='Name']"))
                .sendKeys("");
        driver.findElement(By.xpath("//input[@aria-label='Email address']"))
                .sendKeys("!@!@$!!!!#!$!!");

        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        Assert.assertTrue(isElementPresented(By.xpath("//div[@class='input-error-message']")));

        List<WebElement> warningsList = driver.findElements(By.xpath("//div[@class='input-error-message']"));
        Assert.assertEquals(warningsList.size(), 2);
    }


    @Test
    public void testCheckingCanBeBlankField3() {

        driver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        if (isElementPresented(By.xpath("//div[@class='tp-iframe-wrapper tp-active']"))) {
            driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();
        }
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();

        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='What questions would you like us to answer?']"))
                .sendKeys("!!!!@!!!");
        driver.findElement(By.xpath("//input[@aria-label='Name']"))
                .sendKeys("!@@#$$%^^%$");
        driver.findElement(By.xpath("//input[@aria-label='Email address']"))
                .sendKeys("!@!@$!!!!#!$!!");

        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        Assert.assertTrue(isElementPresented(By.xpath("//div[@class='input-error-message']")));

        List<WebElement> warningsList = driver.findElements(By.xpath("//div[@class='input-error-message']"));
        Assert.assertEquals(warningsList.size(), 1);
    }

    protected Boolean isElementPresented(By element) {
        boolean elementCondition = false;
        try {
            elementCondition = driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }


}
