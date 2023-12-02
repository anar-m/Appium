package akpYukleme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class apk {
    AndroidDriver<AndroidElement> dirver;

    @Test
    public void apkYukleme() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        // eğer kullanmış olduğumuz cihazın android sürümü 6 ya da 6 dan büyükse UiAutomator2'yi kullanmamız gerekiyor
        // eğer kullanmış olduğumuz cihazın android sürümü 6 dan küçükse UiAutomator'u kullanmamız gerekiyor
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\musta\\IdeaProjects\\Appium_T120\\Apps\\arabam.com_5.0.6_Apkpure.apk");

        dirver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        dirver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }


}
