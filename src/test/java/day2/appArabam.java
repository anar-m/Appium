package day2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class appArabam {
    AndroidDriver<AndroidElement> driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        // eger kullanmis oldugumuz cihazin Android surumu 6 ya da 6  dan buyukse UiAutomator2 yi kullanmamiz gerekiyor
        // eger kullanmis oldugumuz cihazin Android surumu 6 dan kucukse UiAuotmator u kullanmamiz gerekiyor.
        capabilities.setCapability("appPackage","com.dogan.arabam");
        // appPackage bir uygulamanin kimlik bilgisidir. biz bu capability sayesinde hangi uygulama uzerinde calisacagimizi test oncesinde belirtebiliriz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // appActivity uzerinde calisacak oldugumuz uygulamanin hangi sayfa penceresinden baslyacagimizi belirtir.
        //yani biz bu capability sayesinde uygulama icersindeki farkli pencerelerden uygulamayi baslatabiliriz. Bunun icin gerekli activity degerlerine sahip olmamiz gerekir.
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void arabamAppTest() throws InterruptedException {
        //  driver.activateApp("com.dogan.arabam");
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='Alırken, satarken kullanırken']").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // arac olarak Volkswagen secilir
        Thread.sleep(1500);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(700,2700)) // press kısmı ekranda tıklama kaydırma işlemi için tıklama yapacağımız ilk nokta
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))) // başlangıç noktası ile bitiş noktası arasındaki gecen süre
                // eğer wait süresi uzun olursa gidilen yol mesafesi daha AZ olur
                // eğer ki wait süresi kısa olursa gidilen yol daha FAZLA olacaktır
                .moveTo(PointOption.point(700,100)) // başlangıç noktasından başlayarak gidilecek bitiş nokyasının koordinatlarını ifade eder
                .release() // parmagımızı tıpkı günlük kullanımdaki gibi ekrandan kaldırma serbest bırakma eylemidir
                .perform(); // verilen action
        Thread.sleep(1000);

        action.press(PointOption.point(450,2250))
                .release()
                .perform();
        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Highline']").click();
        Thread.sleep(750);

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/imageViewSorting").click();
        Thread.sleep(500);
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String aracFiyati = driver.findElementByXPath("//*[@resource-id=\"com.dogan.arabam:id/tvPrice\"]").getText();
        System.out.println(aracFiyati);

       // aracFiyati = aracFiyati.replaceAll(".","").replaceAll(" TL","");
        aracFiyati = aracFiyati.replaceAll("\\D","");

        Assert.assertTrue(Integer.parseInt(aracFiyati)>500000);


    }
}


