package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.FilterPage;
import pom.HomePage;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);
    protected HomePage homePage = new HomePage();
    protected FilterPage filterPage = new FilterPage();

}
