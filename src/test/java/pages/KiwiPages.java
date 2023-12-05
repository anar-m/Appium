package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPages {

    public KiwiPages(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }


    @FindBy(xpath = "(//*[@class='android.widget.Button'])[4]")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "//*[@class='android.view.View'][4]")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "(//*[@text='Anywhere'])[2]")
    public WebElement anywhereButton;

    @FindBy(xpath = "(//*[@text='Anytime'])[2]")
    public WebElement anyTimeButton;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stopButton;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonStopButton;


    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement priceBox;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButton;
}