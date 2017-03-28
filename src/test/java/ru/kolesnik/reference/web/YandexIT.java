package ru.kolesnik.reference.web;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kolesnik.reference.web.step.BrowserStep;
import ru.kolesnik.reference.web.step.YandexPageStep;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Yandex home page integration test.
 */
@Features("Home page")
@Stories("Smoke test for the home page")
public class YandexIT {

  private WebDriver driver;

  private BrowserStep browserStep;

  private YandexPageStep yandexPageStep;
  @Rule
  public final ExternalResource resource = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      driver = new ChromeDriver();
      browserStep = new BrowserStep(driver);
      yandexPageStep = new YandexPageStep(driver);
    }

    @Override
    protected void after() {
      driver.close();
    }
  };

  @Test
  public void testHomePage() {
    browserStep.openYandexHomePage();
    yandexPageStep.assertYandexPageLoaded();
    yandexPageStep.enterSearchTerm(String.valueOf(Thread.currentThread().getId()));
    browserStep.captureScreenshot();
  }

  @Test
  public void testHomePage2() {
    browserStep.openYandexHomePage();
    yandexPageStep.assertYandexPageLoaded();
    yandexPageStep.enterSearchTerm(String.valueOf(Thread.currentThread().getId()));
    browserStep.captureScreenshot();
  }
}
