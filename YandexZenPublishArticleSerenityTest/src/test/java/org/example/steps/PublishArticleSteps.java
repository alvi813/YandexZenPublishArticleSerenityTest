package org.example.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import org.example.steps.serenity.EndUserSteps;


public class PublishArticleSteps {

    @Steps
    EndUserSteps endUserSteps;

    @Given("the user is on the Publication page")
    public void givenTheUserIsOnThePublicationPage() {
        endUserSteps.openPublicationPage();
    }

    @When("the user publish an article with the tag '$tag'")
    public void whenTheUserPublishAnArticleWithTag(String tag) throws InterruptedException {
        endUserSteps.publishArticle(tag);
    }

    @Then("they should see the published YandexZen article with the tag '$tag'")
    public void thenTheyShouldSeeThePublishedYandexZenArticleWithTag(String tag) {
        endUserSteps.should_see_published_article(tag);
    }

}













/*
    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        endUser.is_the_home_page();
    }

    @When("the user looks up the definition of the word '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        endUser.looks_for(word);
    }

    @Then("they should see the definition '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition(definition);
    }
*/
