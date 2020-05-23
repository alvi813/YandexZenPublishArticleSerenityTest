package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;


public class EditArticlePage extends PageObject {

    // кнопка "Опубликовать" на странице редактирования черновика статьи:
    @FindBy(xpath = "//button/span[contains(text(), 'Опубликовать')]")
    private WebElementFacade publishButtonOnTheEditArticlePage;

    //--------------------------------------------------------------

    // форма настроек публикации "Публикация":
    @FindBy(xpath = "//form[@class='publication-settings__form']")
    private WebElementFacade publicationSettingsForm;

    // выбрать изображение на обложку в форме "Публикация":
    @FindBy(xpath = "//div[@class='cover-picker']//div[@class='cover-picker__cover-container']")
    private WebElementFacade chooseImageOnTheCoverOnThePublicationForm;

    // кнопка удаления предложенного тэга в форме "Публикация":
    @FindBy(xpath = "//button[@class='ui-lib-tag-input-child__cross']")
    private WebElementFacade closeTagButtonOnThePublicationForm;

    // поле ввода собственных тэгов в форме "Публикация":
    @FindBy(xpath = "//input[contains(@class, 'ui-lib-tag-input')]")
    private WebElementFacade inputTagFieldOnThePublicationForm;

    // вкладка "Настройки" в форме "Публикация":
    @FindBy(xpath = "//button/span[contains(text(), 'Настройки')]")
    private WebElementFacade settingsTabOnThePublicationForm;

    // окно вкладки "Настройки" в форме "Публикация":
    @FindBy(xpath = "//div[contains(@class, 'publication-settings-additional')]")
    private WebElementFacade settingsWindowOnThePublicationForm;

    // поле-метка "Отключить комментарии" в форме "Публикация" - чекбокс в состоянии Отключено:
    @FindBy(xpath = "//div[@class='publication-settings-content']/div[1]/label[contains(@class, 'ui-lib-checkbox _size_l _with-label')]")
    private WebElementFacade disableCommentsCheckboxLabelOnThePublicationForm_inTheDisabledState;

    // поле-метка чекбокса "Отключить комментарии" в форме "Публикация":
    @FindBy(xpath = "//span[contains(text(), 'Отключить комментарии')]")
    private WebElementFacade disableCommentsCheckboxLabelOnThePublicationForm;

    // кнопка "Опубликовать" в форме "Публикация":
    @FindBy(xpath = "//div[@class='ui-lib-modal__scrollbar-fix']//button/span[contains(text(), 'Опубликовать')]")
    private WebElementFacade publishButtonOnThePublicationForm;

    //--------------------------------------------------------------

    // окно_с_подсказками:
    @FindBy(xpath = "//span[contains(text(), 'Статья')]")
    private WebElementFacade windowWithSuggestions;

    // кнопка закрытия окна_с_подсказками:
    @FindBy(xpath = "//div[@class='close-cross close-cross_black close-cross_size_s help-popup__close-cross']")
    private WebElementFacade closeButtonForWindowWithSuggestions;


    //--------------------------------------------------------------
    //--------------------------------------------------------------



    public void workWithInformationWindowInArticleEditor() {
        try {
            // если появится окно с подсказками:
            if (windowWithSuggestions.isDisplayed()) {
                // закрываем появившееся окно с подсказками:
                closeButtonForWindowWithSuggestions.click();
            }
        } catch (Exception ignored) {
        }
    }


    // нажимаем кнопку "Опубликовать" на странице редактирования черновика:
    public void clickThePublishButtonOnEditArticlePage() {
        publishButtonOnTheEditArticlePage.click();
    }


    // ожидаем появления формы с настройками публикации:
    public void waitAppearingPublicationSettingsForm() {
        publicationSettingsForm.waitUntilVisible();
    }


    // выберем в качестве обложки статьи первую картинку:
    public void chooseFirstImageAsTheCoverOfArticle() {
        chooseImageOnTheCoverOnThePublicationForm.click();
    }


    // удалить все автоматически предложенные тэги, если они присутствуют:
    public void removeAllAutoSuggestedTags() {
        try {
            while (true) {
                if (closeTagButtonOnThePublicationForm.isDisplayed()) {
                    closeTagButtonOnThePublicationForm.click();
                }
            }
        } catch (Exception ignored) {
        }
    }


    // добавим собственные тэги:
    public void addingOurOwnTags(String tags) {
        inputTagFieldOnThePublicationForm.sendKeys(tags, Keys.ENTER);
    }

    public void goToSettingsTab() {
        // перейдём на вкладку "Настройки":
        settingsTabOnThePublicationForm.click();
        // ждём, когда загрузится вкладка "Настройки":
        settingsWindowOnThePublicationForm.waitUntilVisible();
    }


    public void disableCommentsIfTheyAreEnabled() {
        // если комментарии включены, отключим их:
        try {
            if (disableCommentsCheckboxLabelOnThePublicationForm_inTheDisabledState.isDisplayed()) {
                disableCommentsCheckboxLabelOnThePublicationForm.click();
            }
        } catch (Exception ignored) {
        }
    }


    // нажимаем кнопку "Опубликовать" на форме "Публикация":
    public void clickThePublishButtonOnPublicationForm() {
        publishButtonOnThePublicationForm.click();
    }

}
