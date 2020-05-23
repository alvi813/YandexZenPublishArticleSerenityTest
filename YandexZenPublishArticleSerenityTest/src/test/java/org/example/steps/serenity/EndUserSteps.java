package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.EditArticlePage;
import org.example.pages.PublicationPage;
import org.example.pages.PublishedPage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {


    PublicationPage publicationPage;
    EditArticlePage editArticlePage;
    PublishedPage publishedPage;



    // открыть страницу "Публикации":
    @Step
    public void openPublicationPage() {
        publicationPage.open();
    }


    // Выбрать черновик и перейти на страницу редактирования черновика:
    @Step
    public void  selectDraftAndGoToEditArticlePage() throws InterruptedException {
        publicationPage.goToDraftsTab();
        publicationPage.workWithInformationWindowInDrafts();
        publicationPage.checkIfTheArticleDraftExists();
        publicationPage.goToTheEditArticlePage();

    }


    // установить настройки публикации и опубликовать:
    @Step
    public void setPublishingSettingsAndPublish(String tags) {
        editArticlePage.workWithInformationWindowInArticleEditor();
        editArticlePage.clickThePublishButtonOnEditArticlePage();
        editArticlePage.waitAppearingPublicationSettingsForm();
        editArticlePage.chooseFirstImageAsTheCoverOfArticle();
        editArticlePage.removeAllAutoSuggestedTags();
        editArticlePage.addingOurOwnTags(tags);
        editArticlePage.goToSettingsTab();
        editArticlePage.disableCommentsIfTheyAreEnabled();
        editArticlePage.clickThePublishButtonOnPublicationForm();
    }


    // шаги опубликования статьи:
    @Step
    public void publishArticle(String tags) throws InterruptedException {
        selectDraftAndGoToEditArticlePage();
        setPublishingSettingsAndPublish(tags);
    }


    @Step
    public void goToPublishedPageAfterTheArticleIsPublished() {
        publicationPage.shouldBeDisplayed();  // проверим, что после публикации статьи автоматически открылась страница "Публикации":
        publicationPage.goToPublishedTab();
        publicationPage.openPublishedArticle();
    }



    // после публикации пользователь должен увидеть заголовок, текст абзаца, наличие картинки и текст подписи под картинкой:
    @Step
    public void should_see_published_article(String tag) {
        goToPublishedPageAfterTheArticleIsPublished();
        assertThat(publishedPage.getArticleTitle(), not(isEmptyOrNullString()));
        assertThat(publishedPage.getArticleText(), not(isEmptyOrNullString()));
        assertThat(publishedPage.isPageHasImage(), equalTo(true));
        assertThat(publishedPage.getCaptionUnderTheImageText(), not(isEmptyOrNullString()));
        assertThat(publishedPage.getTagText(), containsString(tag));
    }

}













/*
package org.example.steps.serenity;

import org.example.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
 */