package com.wikipedia.fw;

import com.wikipedia.core.BaseHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends BaseHelper {
    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }


    public void confirm() {
        tap(By.id("fragment_onboarding_skip_button"));
    }

    public boolean isMainScreenPresent() {
        return isElementPresent(By.id("main_toolbar_wordmark"));
    }

    public void clickOnSearchBar() {
        tap(By.xpath("//android.widget.TextView[@text=\"Search Wikipedia\"]"));
    }

    public void typeTextInTheSearchBar(String text) {
        pause(500);
        type(By.id("search_src_text"), text);
    }

    public void openFirstLink() {
        tap(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/search_results_list\"]/android.view.ViewGroup[1]"));
    }

    public void saveToFavorite() {
        pause(1000);
        tap(By.id("page_save"));
    }

    public void goToMainPage() {
        driver.navigate().back();
        pause(500);
        tap(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    }

    public void goToSaved() {
        tapWithCoordinates(330,1639);
        tap(By.id("item_title_container"));
    }

    public boolean isPageSaved() {
        return isElementPresent(By.id("page_list_item_description"));
    }
}
