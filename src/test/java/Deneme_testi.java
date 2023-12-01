import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Deneme_testi {

    AndroidDriver<MobileElement> driver;

    @Test
    public void deneme1(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomotor2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\musta\\IdeaProjects\\Appium_T120\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

    }
}
