package com.wikipedia.core;

import com.wikipedia.fw.MainScreenHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    MainScreenHelper mainScreen;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "mob");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", "C:/Tools/wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        mainScreen = new MainScreenHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }


}
