package com.scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DropdownTests extends BaseTest {
    private final int id;

    public DropdownTests(int id) {
        this.id = id;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][]{
                { 0 }, { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }
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
        Boolean isSubItemDisplayed = mainPage.isSubItemAppearedAt(id);
        assertTrue("Подстрочка после клика не появилась", isSubItemDisplayed);
    }
}
