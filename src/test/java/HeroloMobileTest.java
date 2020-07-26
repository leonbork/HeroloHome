import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class HeroloMobileTest extends InstanMobile{

    protected final String urlForTest = "https://automation.herolo.co.il";

    protected final String androidWidgetEditText = "android.widget.EditText";
    protected final String androidViewView = "android.view.View";

    protected final String whatsAppAccessibilityId = "send?phone=972544945333";


    @BeforeTest
    public void before(){
        setup();
        System.out.println("Setup Completed");
        driver.get(urlForTest);
        System.out.println("Chrome loaded site for testing: " + urlForTest);
    }

    @Test (priority = 0)
    public void initialSetup() throws InterruptedException {

        try {
            MobileElement translateOption = driver.findElementById("com.android.chrome:id/infobar_close_button");
            if (translateOption.isDisplayed()){
                translateOption.click();
            }
        }
        catch (NoSuchElementException elementException){
            elementException.printStackTrace();
        }

    }

    @Test
    public void validUserRegister() {
        //find name textbox
        //input name

        //find email textbox
        //input email

        //find phone textbox
        //input phone

        //click Send

    }

    @Test
    public void invalidUserNameRegister() {
        //find name textbox
        //input Invalid name

        //find email textbox
        //input email

        //find phone textbox
        //input phone

        //click Send

    }

    @Test
    public void invalidUserEmailRegister() {
        //find name textbox
        //input  name

        //find email textbox
        //input Invalid email

        //find phone textbox
        //input phone

        //click Send

    }

    @Test
    public void invalidUserPhoneRegister() {
        //find name textbox
        //input  name

        //find email textbox
        //input  email

        //find phone textbox
        //input Invalid phone

        //click Send

    }


    @Test (priority = 3)
    public void WhatsAppIcon(){
        clickByAccessibilityId(whatsAppAccessibilityId);
        try {
            loopWidgetByText(androidViewView, "Chat on WhatsApp with +972 54-494-5333");
            WebElement btn = driver.findElementById("CONTINUE TO CHAT");
            if (btn.isDisplayed()){
                btn.click();
            }

            try {
                WebElement downloadWhatsAppBtn = driver.findElementByAccessibilityId("DOWNLOAD");
                if (downloadWhatsAppBtn.isDisplayed()){
                    System.out.println("Please Download & Register into WhatsApp..");
                }
            }
            catch (NoSuchElementException noSuchElementException){
                System.out.println();
            }
        }
        catch (NoSuchElementException noSuchElementException){
            noSuchElementException.getStackTrace();
        }

    }






    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
