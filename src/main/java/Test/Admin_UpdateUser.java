package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class Admin_UpdateUser extends STW {
@FindBy(id="global-search")
        WebElement Search;

    @FindBy(xpath="//*[@id='form_first_name']")
    WebElement FirstName;

    @FindBy(id="form_last_name")
    WebElement LastName;

    @FindBy(id="//span[@class='ui-checkbox']")
    WebElement Alias;
    @FindBy(id="form_user_alias")
    WebElement AliasValue;

    @FindBy(id="form_mobile_number")
    WebElement Number;

    @FindBy(id="form_email")
    WebElement Mail;

    @FindBy(id="form_position")
    WebElement Position ;
    @FindBy(id="call-fwd-tab")
    WebElement option;

    @FindBy(id="users_save")
    WebElement Next;
    @FindBy(xpath="//*[@id='allow-walkie-talkie-row']")
    WebElement PTT;
    @FindBy(id="select2-Priority-container")
    WebElement Priorite;

    @FindBy(id="allow-voip-video-row")
    WebElement videoCall;
    @FindBy(id="allow-video-streaming-row")
    WebElement VideoStreaming;
    @FindBy(xpath="//div[@class='row checkbox-tip flex-line']")
    WebElement OpStatus;
    @FindBy(id="change-geolocation-manager-row")
    WebElement Dispatch;


@FindBy(id="call-fwd-tab")
WebElement call_fwd;
    @FindBy(xpath="//div[@data-role='user-settings']/div/div")
    WebElement transfer;
    @FindBy(xpath="//div[@data-role='user-settings']/div/div[@class='customized-checkbox']")
    WebElement Custom;

    @FindBy(xpath="//div[@role='dialog']")
    WebElement dialog;
    @FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement error;
    @FindBy(id="activation-tab")
    WebElement Activation;
    @FindBy(id=" ui-checkbox")
    WebElement code;

    WebDriver driver;
    ExtentTest logger;
 ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);



    public Admin_UpdateUser(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;

    }

 public void SerchContact(String profile) throws InterruptedException, IOException{
        Thread.sleep(5000);
       isElementDisplayed( Search);
       Search.sendKeys(profile);
     List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li/div"));

     for (WebElement element : li_All) {
         System.out.println("element est "+element.getText());
         if (element.getText().equals(profile)) {
             isElementDisplayed( element);
             element.click();
             logger.log(Status.PASS, "user is displayed ");
             break;
         }
         else{
             logger.log(Status.FAIL, "user is not displayed ");
             ExtentReportsManager.getscreenshot( driver,logger);

         }

     }


 }




    public  void DeactiveTransfer() throws InterruptedException{
        call_fwd.click();
        Thread.sleep(3000);
        scroll(transfer,driver);
        if (transfer.getAttribute("class").equals("checkbox-switcher on checked")) {
            System.out.println("cette option est deja activé ");
        } else   {
            transfer.click();

        }

        isElementDisplayed( option);
        option.click();
        isElementDisplayed( PTT);
        ActiveOptionRadio(PTT);
        DeactiveOptionRadio(VideoStreaming);
    }




    public void ValidationCode(String profile) throws IOException, InterruptedException{
        SerchContact(profile);
        isElementDisplayed(Activation);
        Activation.click();
        code.click();
        Next.click();
        driver.findElement(By.id("confirm")).click();
        logger.log(Status.PASS,dialog.findElement(By.xpath("//div[2]/div[2]/div")).getText() );
    }
}
