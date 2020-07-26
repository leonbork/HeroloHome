import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InstanMobile {

    protected String appName = "com.android.chrome";
    protected String appActivity = "org.chromium.chrome.browser.document.ChromeLauncherActivity";

    protected String homeScreenElements = appName + ":id/";

    protected AppiumDriver<MobileElement> driver;

    public void setup(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");

        //Change accordingly to the DUT
        caps.setCapability("deviceName", "Lex10");
        caps.setCapability("udid", "171PRQ1047");

        caps.setCapability("appPackage", appName);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("unlockType", "pin");
        caps.setCapability("unlockKey", "2580");
        caps.setCapability("w3c", "false");
        //caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");


        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url, caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("WebDrive Started!! ");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void loopWidgetByText(String widgetClassName, String widgetText) {
        List<MobileElement> elements = driver.findElements(By.className(widgetClassName));
        for (MobileElement element : elements) {
            if (element.getAttribute(("text")).equalsIgnoreCase(widgetText)) {
                element.click();
                break;
            }
        }
    }

    public void clickById(String elementId) {
        WebElement Btn = driver.findElementById(homeScreenElements + elementId);
        if (Btn.isDisplayed()){
            Btn.click();
        }
        else {
            System.out.println(Btn + " Not Displayed By ID");
        }
    }

    public void clickByAccessibilityId(String accessibilityId) {
        WebElement Btn = driver.findElementById(accessibilityId);
        if (Btn.isDisplayed()){
            Btn.click();
        }
        else {
            System.out.println(Btn + " Not Displayed By Accessibility");
        }
    }



}
