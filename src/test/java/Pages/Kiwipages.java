package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Kiwipages {
    public Kiwipages(){

        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }
    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "(//*[@text='Erzurum'])[1]")
    public WebElement kalkisYeri;

    @FindBy(xpath = "//*[@content-desc='Clear All']")
    public WebElement clearAll;

    @FindBy(xpath = "//*[@index='7']")
    public WebElement kalkisSehri;

}
