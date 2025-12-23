package com.scooter.tests;

import com.scooter.page.MainPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DropdownTests extends BaseTest {

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
        // Находим и кликаем на элементы списка в цикле
        for(int i = 0; i < MainPage.numberOfItems; i++) {
            // Кликаем на айтем
            mainPage.clickOnItemAt(i);
            // Дождись появления карточки и кнопки удаления
            Boolean isSubItemDisplayed = mainPage.isSubItemAppearedAt(i);
            assertTrue("Подстрочка после клика не появилась", isSubItemDisplayed);
        }
    }
}
