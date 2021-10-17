package BBC.manager;

import BBC.pages.CoronaNewsPage;
import BBC.pages.HomePage;
import BBC.pages.NewsPage;
import BBC.pages.YourQuestionsPage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public CoronaNewsPage getCoronaNewsPage(){
        return new CoronaNewsPage(driver);
    }

    public YourQuestionsPage getYourQuestionsPage(){
        return new YourQuestionsPage(driver);
    }
}
