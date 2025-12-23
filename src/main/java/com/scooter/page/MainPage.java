package com.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    // Элемент дропдаун листа
    private final By dropDownListElement = By.className("Home_FAQ__3uVm4");
    // Верхняя кнопка Заказать
    private final By orderTopButtonElement = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // Нижняя кнопка Заказать
    private final By orderBottomButtonElement = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    // Кнопка принятия куки
    private final By acceptCookieButton = By.xpath(".//button[text()='да все привыкли']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Метод для принятия куки
    public void acceptCookieButtonClick() {
        clickOnElement(acceptCookieButton);
    }

    public void scrollToDropDownElement() {
        scrollToElement(dropDownListElement);
    }

    public void isDropDownListAvailable() {
        checkAvailability(dropDownListElement);
    }

    public void clickOnOrderButton(Boolean isTop) {
        if (isTop) {
            clickOnElement(orderTopButtonElement);
        } else {
            scrollToElement(orderBottomButtonElement);
            clickOnElement(orderBottomButtonElement);
        }
    }

    public void clickOnItemAt(int position) {
        // Маска для айтемов в дропдаун листе
        String itemElementMask = "accordion__heading-";
        WebElement element = driver.findElement(By.id(itemElementMask + position));
        element.click();
    }

    public Boolean isSubItemAppearedAt(int position) {
        // Маска для сабайтемов в дропдаун листе
        String subItemElementMask = "accordion__panel-";
        // Дожидаемся появления сабайтема
        WebElement displayedElement = driver.findElement(By.id(subItemElementMask + position));
        return displayedElement.isDisplayed();
    }
}
