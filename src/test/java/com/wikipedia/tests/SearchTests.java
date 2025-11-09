package com.wikipedia.tests;

import com.wikipedia.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

@Test
    public void appLaunchTest(){
    app.getMainScreen().clickOnSearchBar();
    app.getMainScreen().typeTextInTheSearchBar("IT");
    app.getMainScreen().openFirstLink();
    app.getMainScreen().saveToFavorite();
    app.getMainScreen().goToMainPage();
    app.getMainScreen().goToSaved();
    Assert.assertTrue(app.getMainScreen().isPageSaved());

}

}
