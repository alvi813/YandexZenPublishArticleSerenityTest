package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class PublishedPage extends PageObject {

    // поле заголовка статьи:
    @FindBy(xpath = "//h1[@class='article__title']")
    private WebElementFacade articleTitle;

    // абзац с текстом:
    @FindBy(xpath = "//p[@class='article-render__block article-render__block_unstyled']")
    private WebElementFacade paragraphText;

    // тэг:
    @FindBy(xpath = "//span[@class='zen-tag-publishers__title']")
    private WebElementFacade articleTag;

    //--------------------------------------------------------------

    // картинка:
    @FindBy(xpath = "//img[@class='article-image__image article-image__image_loaded']")
    private WebElementFacade image;

    // элемент под картинкой (с подписью к картинке):
    @FindBy(xpath = "//figcaption[@class='article-image__caption']")
    private WebElementFacade completedCaptionElement;


    //--------------------------------------------------------------
    //--------------------------------------------------------------



    // получить текст заголовка:
    public String getArticleTitle() {
        return articleTitle.getText();
    }

    // получить текст абзаца статьи:
    public String getArticleText() {
        return paragraphText.getText();
    }

    // проверить, что на странице присутствует элемент с картинкой:
    public boolean isPageHasImage() {
        return image.isPresent();
    }

    // получить текст подписи под картинкой:
    public String getCaptionUnderTheImageText() {
        return completedCaptionElement.getText();
    }

    // получить текст тэга:
    public String getTagText() {
        return articleTag.getText();
    }

}











/*
package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary")
public class DictionaryPage extends PageObject {

    @FindBy(name="search")
    private WebElementFacade searchTerms;

    @FindBy(name="go")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
 */
