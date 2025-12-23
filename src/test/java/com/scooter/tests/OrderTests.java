package com.scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTests extends BaseTest {
    private final Boolean isTopButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTests(Boolean isTopButton, String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.isTopButton = isTopButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "isTopButton: {0}, user: {1}")
    public static Object[][] getDateSetForOrder() {
        return new Object[][]{
                {true, "Адам", "Богов", "г. Эдем, ул. Змия, д.15", "Бульвар Рокоссовского", "89567762322", "01.01.2012", "сутки", "чёрный жемчуг", "Не кидать камни"},
                {false, "Ева", "Богова", "проспект Яблони 6", "Фрунзенская", "+79667659809", "10.10.2012", "двое суток", "серая безысходность", "Можно скидку?"},
        };
    }

    @Test
    public void orderTest() {
        // Открываем страницу
        mainPage.openPage();
        // Принимаем куки
        mainPage.acceptCookieButtonClick();
        // Кликаем на верхнюю или нижнюю кнопку
        mainPage.clickOnOrderButton(isTopButton);
        // Проверяем, что форма отобразилась
        orderPage.isFormAvailable();
        // Проверяем корректность первого хэдера
        Boolean isFirstHeaderCorrect = orderPage.headerEqualsTo(Resources.forWhomHeader);
        assertTrue("Первый хэдер не корректен", isFirstHeaderCorrect);
        // Заполняем первую форму
        orderPage.fillFirstForm(name, surname, address, subway, phoneNumber);
        // Нажимаем на кнопку Далее
        orderPage.pressContinueButton();
        // Проверяем корректность второго хэдера
        Boolean isSecondHeaderCorrect = orderPage.headerEqualsTo(Resources.rentalHeader);
        assertTrue("Второй хэдер не корректен", isSecondHeaderCorrect);
        // Заполняем вторую форму
        orderPage.fillSecondForm(date, rentalPeriod, color, comment);
        // Нажимаем кнопку Заказать
        orderPage.clickOnOrderButton();
        // Ждем появление диалогового окна
        orderPage.waitForModal();
        // Подтверждаем заказ на кнопку Да
        orderPage.clickOnAcceptButton();
        // Проверяем появилась ли финальная модалка
        assertTrue("Кнопка Статус Заказа не появилась", orderPage.isStatusButtonDisplayed());
        // Нажимаем на кнопку Статус Заказа
        orderPage.clickOnStatusButton();
        // Проверяем доступна ли финальная форма заказа
        assertTrue("Финальная форма не отобразилась", orderPage.isStatusFormAvailable());
    }
}
