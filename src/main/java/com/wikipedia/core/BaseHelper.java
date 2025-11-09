package com.wikipedia.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class BaseHelper {

    protected AppiumDriver driver;

    TouchAction touchAction;

    public BaseHelper(AppiumDriver driver) {
        this.driver = driver;
        touchAction = new TouchAction<>((PerformsTouchActions) driver);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
        driver.navigate().back();
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String isTextPresent(By locator) {
        return driver.findElement(locator).getText();
    }

    public void swipe(double start, double stop) {

        Dimension dimension = getDimension();

        int x = dimension.getWidth() / 2;

        int startY = (int) (dimension.getHeight() * start);
        int stopY = (int) (dimension.getHeight() * stop);

        touchAction.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release().perform();
    }

    public Dimension getDimension() {
        return driver.manage().window().getSize();
    }

    public void swipeInElement(By locator, double start, double stop) {
        Dimension dimension = getDimension();

        //get activity points
        int startY = (int) (dimension.getHeight() * start);
        int stopY = (int) (dimension.getHeight() * stop);

        //get locator's middle point
        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;

        touchAction.longPress(PointOption.point(middleX, startY))
                .moveTo(PointOption.point(middleX, stopY))
                .release().perform();
    }

    public void tapWithCoordinates(int x, int y) {

        touchAction.tap(PointOption.point(x, y))
                .release().perform();
    }

    public void longPressWithCoordinates(By locator) {
        Dimension dimension = getDimension();

        int x = dimension.getWidth() / 2;

        WebElement element = driver.findElement(locator);
        int leftY = element.getLocation().getY();
        int rightY = leftY + element.getSize().getHeight();
        int middleY = (leftY + rightY) / 2;

        touchAction.longPress(PointOption.point(x, middleY))
                .release().perform();
    }

}
