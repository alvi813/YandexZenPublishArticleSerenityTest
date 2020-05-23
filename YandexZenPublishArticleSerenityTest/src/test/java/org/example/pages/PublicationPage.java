package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


@DefaultUrl("https://zen.yandex.ru/profile/editor/id/5ea219f9b6e0833eb9eeaa9f")

public class PublicationPage extends PageObject {

    // вкладка "Черновики":
    @FindBy(xpath = "//span[contains(text(), 'Черновики')]")
    private WebElementFacade draftsTab;

    // карточка статьи:
    @FindBy(xpath = "//div[@class='card-cover-publication card-cover-publication_type_article']")
    private WebElementFacade articleCardOnThePublicationPage;

    // вкладка "Опубликованные":
    @FindBy(xpath = "//span[contains(text(), 'Опубликованные')]")
    private WebElementFacade publishedTab;

    // Заголовок страницы "Публикации":
    @FindBy(xpath = "//div[@class='publications-groups-view__title']")
    private WebElementFacade publicationPageTitle;


   // publication-card-item publication-card-item_type_image publication-card-item_content_article

    //--------------------------------------------------------------

    // окно_с_подсказками:
    @FindBy(xpath = "//div[@class='notification-popup__content']")
    private WebElementFacade windowWithSuggestions;

    // кнопка закрытия окна_с_подсказками:
    @FindBy(xpath = "//button[@class='ui-lib-modal__close']")
    private WebElementFacade closeButtonForWindowWithSuggestions;


    //--------------------------------------------------------------
    // --------------------------------------------------------------


    // перейдём на вкладку "Черновики":
    public void goToDraftsTab() throws InterruptedException {
        // ждём, пока появится вкладка "Черновики":
        draftsTab.waitUntilVisible();
        // нажать на вкладку с надписью "Черновики":
        draftsTab.click();
    }


    public void workWithInformationWindowInDrafts() {
        //после некоторого количества публикаций появляется окно с различного рода информацией от яндекс-дзен
        // если появится окно:
        try {
            if (windowWithSuggestions.isDisplayed()) {
                // закрываем появившееся окно:
                closeButtonForWindowWithSuggestions.click();
            }
        } catch (Exception ignored) {
        }
    }


    public void checkIfTheArticleDraftExists() throws InterruptedException {
        // проверим, существует ли в данный момент черновик статьи.
        // Если нет, ждём, когда появится:
        boolean elementIsPresent = false;
        for (int i = 0; i < 10; i++) {
            try {
                if (articleCardOnThePublicationPage.isPresent()) {
                    elementIsPresent = true;
                    break;
                }
            } catch (Exception ignored) {
                wait(4000);
            }
        }

        // Если черновик так и не появился, прервём дальнейшее выполнение программы:
        if (!elementIsPresent) {
            System.exit(1);
        }
    }


    // перейдём на страницу редактирования статьи:
    public void goToTheEditArticlePage() {
        articleCardOnThePublicationPage.click();
    }


    // перейдём на вкладку "Опубликованные":
    public void goToPublishedTab() {
        // ждём, пока появится вкладка "Опубликованные":
        publishedTab.waitUntilVisible();
        // нажать на вкладку с надписью "Опубликованные":
        publishedTab.click();
    }


    // откроем опубликованную статью:
    public void openPublishedArticle() {
        // проверим, существует ли опубликованная статья:
        articleCardOnThePublicationPage.isPresent();
        //если существует, откроем её:
        articleCardOnThePublicationPage.click();
    }

}
