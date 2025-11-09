package com.wikipedia.core;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {
    protected AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
        app.getMainScreen().confirm();
        Assert.assertTrue(app.getMainScreen().isMainScreenPresent());

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }
}
