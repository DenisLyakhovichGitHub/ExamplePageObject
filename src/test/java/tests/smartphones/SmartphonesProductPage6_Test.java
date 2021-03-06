package tests.smartphones;

import helpers.JSExec;
import models.SmartphoneJB;
import org.junit.jupiter.api.Test;
import pages.*;
import tests.BaseTest;

// Тест
public class SmartphonesProductPage6_Test extends BaseTest {
  @Test
  // Проверка
  public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
    // 1. Arrange
    SmartphoneJB smartphoneJB = new SmartphoneJB( 8, "Samsung");
    // String product = "Samsung"; // производитель
    // String ram = "8 Гб"; // объем ОП

    // 2. Act
    SmartphoneProductPage smartphoneProductPage = getProductPage(smartphoneJB);

    // 3. Assert
    String expected = "Купить 6.7\" Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый в интернет магазине DNS. Характеристики, цена Samsung Galaxy Z Flip3 | 4845670";
    SmartphoneProductPageAssert smartphoneProductAssert = new SmartphoneProductPageAssert(smartphoneProductPage);
    smartphoneProductAssert.pageTitleEquals(expected);
  }

  // Получение страницы с продуктом
  public SmartphoneProductPage getProductPage(SmartphoneJB smartphoneJB) {
    // Открыть страницу https://www.dns-shop.ru/
    driver.get("https://www.dns-shop.ru/");
    // ***** Стартовая страница сайта DNS *****
    StartPageWithElements startPage = new StartPageWithElements(driver);
    // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
    startPage.linkSmartsAndGadgetsMove();
    // Нажатие на ссылку "Смартфоны"
    startPage.linkSmartsClick();

    // ***** Страница "Смартфоны" *****
    SmartphonesPageWithElements smartphonesPage = new SmartphonesPageWithElements(driver);
    // Нажатие на выпадашку "Сортировка"
    smartphonesPage.accordeonSortClick();
    // Установка сортировки "Сначала дорогие"
    smartphonesPage.rbtnExpensiveClick();
    // Прокрутка страницы вниз
    JSExec.scrollBy(0, 300);
    // Установка фильтра "Производитель"
    smartphonesPage.chbxCompanyClick(smartphoneJB.getCompany());
    // Прокрутка страницы вниз
    JSExec.scrollBy(0, 300);
    // Нажатие на гармошку "Объем оперативной памяти"
    smartphonesPage.accordeonRAMClick();
    // Прокрутка страницы вниз
    JSExec.scrollBy(0, 300);
    // Установка фильтра "Объем оперативной памяти"
    smartphonesPage.chbxRAMClick(smartphoneJB.getRam() + " Гб");
    // Прокрутка страницы вниз
    JSExec.scrollBy(0, 300);
    // Нажатие на кнопку "Применить"
    smartphonesPage.btnApplyClick();
    // Прокрутка страницы вверх
    JSExec.scrollBy(0, -500);
    // Нажатие на ссылку первого продукта в списке
    smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый");
    //smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy S20 FE 128 ГБ белый");
    return new SmartphoneProductPage(driver);
  }
}
