package praktikum.tests;

import Scooter.MainPage;
import Scooter.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }

        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    private void startBrowserChrome() {
        driver = new ChromeDriver();
    }

    private void startBrowserFirefox() {
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        // Закрываю браузер
        driver.quit();
    }
}
