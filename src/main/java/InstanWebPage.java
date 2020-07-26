import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InstanWebPage {

    private static InstanWebPage instance=null;
    private WebDriver driver;
    public WebDriverWait wait;

    public WebDriver openChromeBrowser() throws IOException {
        System.setProperty("webdriver.chrome.driver", new File("./src/test/resources/drivers/chromedriver").getCanonicalPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://automation.herolo.co.il/");
        driver.manage().window().maximize();
        return driver;
    }


    public static InstanWebPage getInstance(){
        if(instance==null){
            instance = new InstanWebPage();
        }
        return instance;
    }

    public void touchFooter(){
        WebElement footer = driver.findElement(By.className("Footer__FooterWrapper-sc-1xqajj9-0 jhnVNJ"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("שם...")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector()));

        if (footer.isDisplayed()){
            //driver.findElement(B)
        }

    }
}
