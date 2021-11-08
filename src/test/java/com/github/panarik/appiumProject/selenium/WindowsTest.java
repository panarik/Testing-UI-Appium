package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;

public class WindowsTest extends BaseTest {

    private static JavascriptExecutor js = (JavascriptExecutor) driver;
    private static String window_1; //first browser window
    private static String window_2; //second browser window

    @BeforeEach
    public void init(){
        driver.get("http://127.0.0.1:5500/modals.html");
    }

    @Test
    public void switch_test() throws InterruptedException {
        window_1 = driver.getWindowHandle(); //current window
        js.executeScript("window.open()"); //open new window
        Set<String> list = driver.getWindowHandles(); //get list with all windows names
        //find window_2 from list
        for (String s : list) {
            if (!s.equals(window_1)) window_2 = s;
        }

        Thread.sleep(1000); //debug

        //switch to second window
        driver.switchTo().window(window_2);
        driver.get("http://127.0.0.1:5500/modals.html");

        Thread.sleep(1000); //debug

        //close second window
        driver.close();

        Thread.sleep(1000); //debug

        //switch to first window
        driver.switchTo().window(window_1);

        Thread.sleep(3000); //debug
        driver.close();
    }
}