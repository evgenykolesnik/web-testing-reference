package ru.kolesnik.reference.web.step;

import static org.hamcrest.MatcherAssert.assertThat;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kolesnik.reference.web.page.YandexPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * TODO: add meaningful description (YandexPageStep).
 */
public class YandexPageStep {

  private final WebDriverWait wait;

  private final YandexPage yandexPage;

  public YandexPageStep(WebDriver driver) {
    this.wait = new WebDriverWait(driver, 5);
    this.yandexPage = new YandexPage(driver);
  }

  @Step
  public void enterSearchTerm(String searchTerm) {
    yandexPage.getSearchBlock().getSearchTermTextInput().sendKeys(searchTerm);
  }

  @Step
  public void assertYandexPageLoaded() {
    assertThat("Yandex page is loaded", wait.until(isLoaded()));
  }

  private Function<WebDriver, Boolean> isLoaded() {
    return new Function<WebDriver, Boolean>() {
      public Boolean apply(WebDriver input) {
        return yandexPage.getSearchBlock().isDisplayed() &&
            yandexPage.getSearchBlock().getSearchTermTextInput().isDisplayed() &&
            yandexPage.getSearchBlock().getSearchButton().isDisplayed();
      }
    };
  }
}
