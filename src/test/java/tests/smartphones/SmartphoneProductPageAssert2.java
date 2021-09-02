package tests.smartphones;
import org.junit.jupiter.api.Assertions;
import steps.SmartphoneProductPageSteps;
import pages.SmartphoneProductPage;

public class SmartphoneProductPageAssert2 {
  SmartphoneProductPageSteps smartphoneProductPageSteps;

  // Конструктор
  public SmartphoneProductPageAssert2(SmartphoneProductPageSteps smartphoneProductPageSteps) {
    this.smartphoneProductPageSteps = smartphoneProductPageSteps;
  }

  // Проверка / Утверждение (Матчер)
  public void pageTitleEquals(String expected) {
    String actual = smartphoneProductPageSteps.pageTitle();
    Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
  }

}
