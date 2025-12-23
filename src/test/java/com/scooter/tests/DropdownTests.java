package com.scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;

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
                { 0, Resources.answer1 },
                { 1, Resources.answer2 },
                { 2, Resources.answer3 },
                { 3, Resources.answer4 },
                { 4, Resources.answer5 },
                { 5, Resources.answer6 },
                { 6, Resources.answer7 },
                { 7, Resources.answer8 }
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
        WebElement displayedSubItem = mainPage.subItemAppearedAt(id);
        assertTrue("Подстрочка после клика не появилась", displayedSubItem.isDisplayed());
        // Проверяем текст ответа на вопрос
        Boolean isTextMatching = mainPage.isSubItemTextMatches(displayedSubItem, text);
        assertTrue("Текст сабайтема " + id + " различается", isTextMatching);
    }
}
