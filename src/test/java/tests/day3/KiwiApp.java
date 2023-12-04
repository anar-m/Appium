package tests.day3;

import Pages.Kiwipages;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    Kiwipages pages = new Kiwipages();


    @Test
    public void kiwiApptest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(pages.misafirButonu.isDisplayed());

        // misafir olarak devam et e tiklanir
        pages.misafirButonu.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        for (int i = 0; i < 3; i++) {
            ReusableMethods.tiklamaMethodu(700,2826,1000);
        }
        Thread.sleep(1500);

        // Trip type,one way olarak secilir
        ReusableMethods.tiklamaMethodu(303,849,500);
        pages.oneWayButton.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        pages.kalkisYeri.click();
        ReusableMethods.tiklamaMethodu(1353,190,500);
        pages.clearAll.click();
        ReusableMethods.screenScrollMethod(716,1635,200,716,72,100);
        pages.kalkisSehri.click();


        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }

}
