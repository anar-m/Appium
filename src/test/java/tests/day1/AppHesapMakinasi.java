package tests.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppHesapMakinasi {

    AndroidDriver<AndroidElement> driver;
    // Android driver sadece android cihazlar için oluşturulmuş dir driverdir.
    // Android cihazlar için erekli olan hazır methodları bu dirver ile birlikte kullanılarak cihaz ile
    //ilgili işlemleri yapabiliriz.

   // AppiumDriver<MobileElement> driver2;
    // Appium dirver ise hem Ios hem de Android işletim sistemine sahip olan cihazlar için tasarlanmıştır.
    // Bu dirver ile birlikte iki farklı platform da driver ile işlem gerçekleştirebiliriz

    //EN TEMEL FARK !!!!!!!! Andorid cihazlar kullanım farklılıkları daha zengin olduğu için AndroidDriver sadece cihazlara
    // özel tasarlanmıştır.
    //BU da bizlere android cihazlar daha kullanışlı bir driver kullanmamıza fayda sağlar

    @Test
    public void hesapmakinasi() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        // eğer kullanmış olduğumuz cihazın android sürümü 6 ya da 6 dan büyükse UiAutomator2'yi kullanmamız gerekiyor
        // eğer kullanmış olduğumuz cihazın android sürümü 6 dan küçükse UiAutomator'u kullanmamız gerekiyor
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\musta\\IdeaProjects\\Appium_T120\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // kullanici gerekli kurulumlari yapar
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.findElementByAccessibilityId("2").isDisplayed());

        // uygulamanin acildigini dogrular
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementByAccessibilityId("5").click();

        // 100 un 5 katininin 500 oldugunu hesap makinasindan dogrulayalim
        String sonucKutusu = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println(sonucKutusu);
        Assert.assertEquals(Integer.parseInt(sonucKutusu),500);

    }

}
