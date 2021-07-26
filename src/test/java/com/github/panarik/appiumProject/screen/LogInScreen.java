package com.github.panarik.appiumProject.screen;

import com.github.panarik.appiumProject.util.SetupDevice;
import io.appium.java_client.MobileElement;

public class LogInScreen {

    //Actions on singIn screen
    public static MobileElement enter = SetupDevice.appiumDriver.findElementById("com.github.panarik.smartFeatures:id/sign_in_without_auth");

    public static void onboardingScenario() {
        enter.click();
    }
}
