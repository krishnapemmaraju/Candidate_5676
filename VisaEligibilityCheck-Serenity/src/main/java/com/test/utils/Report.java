package com.test.utils;

import com.test.hooks.Setup;
import io.cucumber.core.api.*;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Report {

    EnvironmentVariables env;
    private String baseURL;
    private WebDriver driver;
    static Scenario scenario;

    public void getBaseURL(){
         baseURL = EnvironmentSpecificConfiguration.from(env).getProperty("environment.sandbox.url");
    }

    public static void pass(){
        Assert.assertTrue(true);
    }

    public static void fail(){
        Assert.assertFalse(false);
    }

    public  static void fail(String text,WebDriver driver) {
        System.out.println("Is it coming here");
        writeHeadingForFail(text);
        Assert.assertTrue(text,false);
        attachScreenShot(driver,text);
    }


    public static void writeHeading(String text) {
        String html = "<h3><font color='blue'>"+text+"</font></h3>";
        scenario.attach(html.getBytes(), "text/html",html);
    }

    public static void writeHeadingForFail(String text) {
        String html = "<h4><font color='red'>"+text+"</font></h4>";
        scenario.attach(html.getBytes(), "text/html",html);

    }

    public static void attachScreenShot(WebDriver driver) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","Screen Text");
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
            wde.printStackTrace();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    public  static void attachScreenShot(WebDriver driver,String text) {

        try {
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",text);
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
            wde.printStackTrace();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}
