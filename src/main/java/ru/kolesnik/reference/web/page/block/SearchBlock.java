package ru.kolesnik.reference.web.page.block;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Yandex search block.
 */
@Name("Search block")
@FindBy(className = "search2")
public class SearchBlock extends HtmlElement {

  @FindBy(id = "text")
  private WebElement searchTermTextInput;

  @FindBy(className = "search2__button")
  private WebElement searchButton;

  public WebElement getSearchTermTextInput() {
    return searchTermTextInput;
  }

  public WebElement getSearchButton() {
    return searchButton;
  }
}
