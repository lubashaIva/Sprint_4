package Scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void checkAvailability(By element) {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    void scrollToElement(By element) {
        WebElement dropDownElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dropDownElement);
    }

    void enterText(String text, By element) {
        WebElement chosenElement = driver.findElement(element);
        chosenElement.sendKeys(text);
    }

    void clickOnElement(By element) {
        WebElement chosenElement = driver.findElement(element);
        chosenElement.click();
    }
}
