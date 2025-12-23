package com.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {
    // Первый экран заказа
    private final By firstPageElement = By.className("Order_Form__17u6u");
    // Элемент заголовка
    private final By headerElement = By.className("Order_Header__BZXOb");
    // Поле Имя
    private final By nameInputElement = By.xpath(".//input[@placeholder='* Имя']");
    // Поле Фамилия
    private final By familyNameInputElement = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле Адрес
    private final By addressInputElement =By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Станция Метро
    private final By metroStationInputElement = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле Телефон
    private final By phoneNumberInputElement = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private final By continueButtonElement = By.xpath(".//button[text()='Далее']");
    // Поле Когда привезти самокат
    private final By whenInputElement = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле Срок аренды
    private final By periodInputElement = By.className("Dropdown-root");
    // Поле Комментарий для курьера
    private final By commentInputElement = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    private final By orderButtonElement = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    // Модальное окно с подтверждением заказа
    private final By confirmationModalElement = By.className("Order_ModalHeader__3FDaJ");
    // Кнопка согласия на создание заказа
    private final By acceptButtonElement = By.xpath(".//button[text()='Да']");
    // Кнопка перехода на статус заказа
    private final By statusButtonElement = By.xpath(".//button[text()='Посмотреть статус']");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void enterNameText(String text) {
        enterText(text, nameInputElement);
    }

    public void enterFamilyNameText(String text) {
        enterText(text, familyNameInputElement);
    }

    public void enterAddressText(String text) {
        enterText(text, addressInputElement);
    }

    public void enterMetroStation(String text) {
        clickOnElement(metroStationInputElement);
        By stationElement = By.xpath(".//div[text()='" + text + "']");
        scrollToElement(stationElement);
        clickOnElement(stationElement);
    }

    public void enterPhoneText(String text) {
        enterText(text, phoneNumberInputElement);
    }

    public void enterCommentText(String text) {
        enterText(text, commentInputElement);
    }

    public void pressContinueButton() {
        clickOnElement(continueButtonElement);
    }

    public void enterWhenText(String text) {
        enterText(text, whenInputElement);
    }

    public void enterPeriodText(String text) {
        clickOnElement(headerElement);
        clickOnElement(periodInputElement);
        By element = By.xpath(".//div[text()='" + text + "']");
        scrollToElement(element);
        clickOnElement(element);
    }

    public void chooseColor(String text) {
        By chosenColor = By.xpath(".//label[text()='" + text + "']");
        clickOnElement(chosenColor);
    }

    public void clickOnOrderButton() {
        clickOnElement(orderButtonElement);
    }

    public void clickOnAcceptButton() {
        clickOnElement(acceptButtonElement);
    }

    public void clickOnStatusButton() {
        clickOnElement(statusButtonElement);
    }

    public void waitForModal() {
        checkAvailability(confirmationModalElement);
    }

    public void waitForStatusButton() {
        checkAvailability(statusButtonElement);
    }

    public void isFormAvailable() {
        checkAvailability(firstPageElement);
    }

    public Boolean headerEqualsTo(String text) {
        WebElement element = driver.findElement(headerElement);
        return element.getText().equals(text);
    }
}
