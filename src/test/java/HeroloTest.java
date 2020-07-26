import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HeroloTest extends InstanWebPage {
    private InstanWebPage automation= InstanWebPage.getInstance();
    private WebDriver driver;

    @BeforeClass
    public void setup()throws IOException {
        try {
            openChromeBrowser();
        }
        catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }


    @Test
    public void firstTest(){
        WebElement logo = driver.findElement(By.id("logom"));

        if (logo.isDisplayed()){
            System.out.println("Verification Successful");
        }
        else{
            System.out.println("Verification Failed");

        }
    }


    @AfterClass
    public void TearDown(){
        driver.quit();
    }

}
