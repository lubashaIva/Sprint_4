package com.scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DropdownTests extends BaseTest {
    private final int id;
    private final String text;

    public DropdownTests(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Parameterized.Parameters(name = "Question: {0}, Answer: {1}")
    public static Object[][] getDateSetForOrder() {
        return new Object[][]{
                { 0, Resources.paymentAnswer},
                { 1, Resources.orderAnswer},
                { 2, Resources.dateAnswer},
                { 3, Resources.howQuickAnswer},
                { 4, Resources.supportPhoneAnswer},
                { 5, Resources.scooterBatteryAnswer},
                { 6, Resources.penaltyAnswer},
                { 7, Resources.locationAnswer}
        };
    }

    @Test
    public void checkDropdown() {
        // Открываем страницу
        mainPage.openPage();
        // Принимаем куки
        mainPage.acceptCookieButtonClick();
        // Найдем класс выпадающего списка и сделаем скролл до него
        mainPage.scrollToDropDownElement();
        // Проверяем, что список на экране
        mainPage.isDropDownListAvailable();
        // Кликаем на айтем
        mainPage.clickOnItemAt(id);
        // Дождись появления карточки и кнопки удаления
        Boolean displayedSubItem = mainPage.isSubItemAppearedAt(id);
        assertTrue("Подстрочка после клика не появилась", displayedSubItem);
        // Проверяем текст ответа на вопрос
        Boolean isTextMatching = mainPage.isSubItemTextMatches(id, text);
        assertTrue("Текст сабайтема " + id + " различается", isTextMatching);
    }
}
