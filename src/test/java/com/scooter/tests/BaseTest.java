package com.scooter.tests;

import com.scooter.page.MainPage;
import com.scooter.page.OrderPage;
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
        // Разворачиваем браузер на весь экран
        driver.manage().window().maximize();

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
