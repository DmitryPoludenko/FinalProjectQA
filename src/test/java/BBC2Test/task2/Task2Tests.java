package BBC2Test.task2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void checkScottishChampionshipFootballScoreInAug2021() {

        String championship = "Scottish Championship";
        String teamLeft = "Dunfermline";
        String teamRight = "Arbroath";
        String teamLeftScore = "0";
        String teamRightScore = "3";


        driver.findElement(By.xpath("//li[@class='orb-nav-sport']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Football']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Scores & Fixtures']")).click();
        driver.findElement(By.xpath("//input[@class='sp-c-search__input gel-1/1']"))
                .sendKeys(championship, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(@href,'/2021-08')]")).click();


        WebElement leftTeam = driver
                .findElement(By.xpath("//a[@href='/sport/football/58289773']//span[@data-team-id='TFBB329']"));
        WebElement rightTeam = driver
                .findElement(By.xpath("//a[@href='/sport/football/58289773']//span[@data-team-id='TFBB337']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));

        driver.findElement(By.xpath("//a[.//span='Dunfermline' and .//span='Arbroath']")).click();

        leftTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB329']"));
        rightTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB337']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));

    }

    @Test
    public void checkPremierLeagueFootballScoreInMay2021() {

        String championship = "Premier League";
        String teamLeft = "Aston Villa";
        String teamRight = "Chelsea";
        String teamLeftScore = "2";
        String teamRightScore = "1";

        driver.findElement(By.xpath("//li[@class='orb-nav-sport']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Football']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Scores & Fixtures']")).click();
        driver.findElement(By.xpath("//input[@class='sp-c-search__input gel-1/1']"))
                .sendKeys(championship, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.xpath("//button[contains(@class,'sp-c-content-slider__button--prev')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'/2021-05')]")).click();


        WebElement leftTeam = driver
                .findElement(By.xpath("//a[@href='/sport/football/57132104']//span[@data-team-id='TFBB7']"));
        WebElement rightTeam = driver
                .findElement(By.xpath("//a[@href='/sport/football/57132104']//span[@data-team-id='TFBB8']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));

        driver.findElement(By.xpath("//a[.//span='Aston Villa' and .//span='Chelsea']")).click();

        leftTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB7']"));
        rightTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB8']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));
    }

    @Test
    public void checkChampionsLeagueFootballScoreInSep2021() {

        String championship = "Champions League";
        String teamLeft = "Bayern Munich";
        String teamRight = "Dynamo Kyiv";
        String teamLeftScore = "5";
        String teamRightScore = "0";

        driver.findElement(By.xpath("//li[@class='orb-nav-sport']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Football']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Scores & Fixtures']")).click();
        driver.findElement(By.xpath("//input[@class='sp-c-search__input gel-1/1']"))
                .sendKeys(championship, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(@href,'/2021-09')]")).click();

        WebElement leftTeam = driver.
                findElement(By.xpath("//a[@href='/sport/football/58742042']//span[@data-team-id='TFBB156']"));
        WebElement rightTeam = driver.
                findElement(By.xpath("//a[@href='/sport/football/58742042']//span[@data-team-id='TFBB194']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));

        driver.findElement(By.xpath("//a[.//span='Bayern Munich' and .//span='Dynamo Kyiv']")).click();

        leftTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB156']"));
        rightTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB194']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));
    }

    @Test
    public void checkChampionshipFootballScoreInNov2020() {

        String championship = "Championship";
        String teamLeft = "Wycombe Wanderers";
        String teamRight = "Huddersfield Town";
        String teamLeftScore = "0";
        String teamRightScore = "0";

        driver.findElement(By.xpath("//li[@class='orb-nav-sport']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Football']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Scores & Fixtures']")).click();
        driver.findElement(By.xpath("//input[@class='sp-c-search__input gel-1/1']"))
                .sendKeys(championship, Keys.ARROW_DOWN, Keys.ENTER);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//button[contains(@class,'sp-c-content-slider__button--prev')]")))
                .click().pause(500)
                .click().build().perform();
        driver.findElement(By.xpath("//a[contains(@href,'/2020-11')]")).click();

        WebElement leftTeam = driver
                .findElement(By.xpath("//a[@href='/sport/football/54969161']//span[@data-team-id='TFBB112']"));
        WebElement rightTeam = driver
                .findElement(By.xpath("//a[@href='/sport/football/54969161']//span[@data-team-id='TFBB38']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));

        driver.findElement(By.xpath("//a[.//span='Wycombe Wanderers' and .//span='Huddersfield Town']")).click();

        leftTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB112']"));
        rightTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB38']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));
    }

    @Test
    public void checkGermanBundesligaFootballScoreInApr2021() {

        String championship = "German Bundesliga";
        String teamLeft = "Borussia Dortmund";
        String teamRight = "Werder Bremen";
        String teamLeftScore = "4";
        String teamRightScore = "1";

        driver.findElement(By.xpath("//li[@class='orb-nav-sport']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Football']")).click();
        driver.findElement(By.xpath("//a[@data-stat-title='Scores & Fixtures']")).click();
        driver.findElement(By.xpath("//input[@class='sp-c-search__input gel-1/1']"))
                .sendKeys(championship, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.xpath("//button[contains(@class,'sp-c-content-slider__button--prev')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'/2021-04')]")).click();

        WebElement leftTeam = driver.
                findElement(By.xpath("//a[@href='/sport/football/56795042']//span[@data-team-id='TFBB157']"));
        WebElement rightTeam = driver.
                findElement(By.xpath("//a[@href='/sport/football/56795042']//span[@data-team-id='TFBB171']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));

        driver.findElement(By.xpath("//a[.//span='Borussia Dortmund' and .//span='Werder Bremen']")).click();

        leftTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB157']"));
        rightTeam = driver.findElement(By.xpath("//div[@class='football-oppm-header']//span[@data-team-id='TFBB171']"));

        assertTrue(leftTeam.getText().contains(teamLeft));
        assertTrue(rightTeam.getText().contains(teamRight));
        assertTrue(leftTeam.getText().contains(teamLeftScore));
        assertTrue(rightTeam.getText().contains(teamRightScore));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
