package ru.kolesnik.reference.web.step;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Browser steps.
 */
public class BrowserStep {

  private final WebDriver driver;

  public BrowserStep(WebDriver driver) {
    this.driver = driver;
  }

  @Step
  public void openYandexHomePage() {
    driver.get("https://yandex.ru/");
  }

  @Step
  public void closeBrowser() {
    driver.close();
  }

  @Step
  @Attachment
  public byte[] captureScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
