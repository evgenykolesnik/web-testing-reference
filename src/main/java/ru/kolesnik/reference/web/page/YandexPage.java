package ru.kolesnik.reference.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.kolesnik.reference.web.page.block.SearchBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Yandex home page.
 */
public class YandexPage {

  private SearchBlock searchBlock;

  public YandexPage(WebDriver driver) {
    PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
  }

  public SearchBlock getSearchBlock() {
    return searchBlock;
  }
}
