package com.github.panarik.appiumProject.testNG.appium.simple.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.github.panarik.appiumProject.testNG.appium.simple.util.Configs.GLOBAL_WAITING;

/**
 * Класс, с единым инстансом для использования в тестах.
 * При каждом конкретном запуске тестов, класс определяет подключенное устройство и создаёт конкретный инстанс для него.
 */
public class AppiumController {

    // Создаём драйвера.
    private AndroidDriver<MobileElement> androidDriver;
    private IOSDriver<MobileElement> iOSDriver;

    public void setupAndroid() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.VERSION, "10");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 9");
        cap.setCapability(MobileCapabilityType.UDID, "UDID");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60); //через 60 сек отключаем девайс
        cap.setCapability(MobileCapabilityType.APP, "path/to/app.apk");
        cap.setCapability("unlockType", "pattern"); //тип разблокировки девайса
        cap.setCapability("unlockKey", "1234"); //ключ разблокировки

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            androidDriver = new AndroidDriver<>(url, cap);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(androidDriver.getSessionDetails());
        System.out.println(androidDriver.getSettings());

        //сетап дефолтного ожидания
        androidDriver.manage().timeouts().implicitlyWait(GLOBAL_WAITING, TimeUnit.SECONDS);
    }

    public void setupIOS() {
        //ToDo: Сделать iOS.
    }

    /**
     * Вызываем AndroidDriver из любого места проекта.
     *
     * @return AndroidDriver
     */
    public AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }

    /**
     * Вызываем IOSDriver из любого места проекта.
     *
     * @return IOSDriver
     */
    public IOSDriver<MobileElement> getIOSDriver() {
        return iOSDriver;
    }

    /**
     * Тушим все драйверы.
     */
    public void stop() {
        if (androidDriver != null) androidDriver.quit();
        if (iOSDriver != null) iOSDriver.quit();
    }

}
