package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class Admin_CreateUSer extends STW{
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


    @FindBy(id="users_save")
    WebElement Next;
    @FindBy(id="allow-walkie-talkie-row")
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

    @FindBy(xpath="//div[@data-role='user-settings']/div/div")
    WebElement transfer;
    @FindBy(xpath="//div[@data-role='user-settings']/div/div[@class='customized-checkbox']")
    WebElement Custom;

    @FindBy(xpath="//div[@role='dialog']")
    WebElement dialog;
    @FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement error;



    WebDriver driver;
    ExtentTest logger;
 ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);


    public Admin_CreateUSer(WebDriver driver,     ExtentTest logger) {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }

    public void option(String FName,String LName , String number) throws InterruptedException, IOException{
        isElementDisplayed(FirstName);
        Thread.sleep(6000);
        FirstName.sendKeys(FName);
        LastName.sendKeys(LName);
       // Alias.click();
        //AliasValue.sendKeys(Aliasvalue);
        Number.sendKeys(number);
        Mail.sendKeys("test.team.sw@gmail.com");
        Position.sendKeys("QA");
        Thread.sleep(3000);
        isElementDisplayed(Next);
        Next.click();
        PTT.click();
        Priorite.click();
         SelectScroll("Niveau 252");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until((ExpectedConditions.elementToBeClickable(videoCall)));
        videoCall.click();
        VideoStreaming.click();
       // OpStatus.click();
        Dispatch.click();
        Next.click();

    }



    public void SelectScroll(String Parametre){
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
        // System.out.println(li_All.size());
        for (WebElement element : li_All) {
            System.out.println("element est "+element.getText());
            if (element.getText().equals(Parametre)) {
                scroll(element, driver);
                element.click();
                break;
            }
        }
    }



    public void TransferCallToContact(String status,String parametre) throws InterruptedException{
        transfer.click();
        Custom.click();

        List<WebElement> li_All=driver.findElements(By.xpath("//div[@class='row-with-switcher']/label"));
        for (WebElement element : li_All) {
            System.out.println("element est " + element.getText());
            if (element.getText().equals(status)) {
                WebElement parent=element.findElement(By.xpath(".//parent::*//parent::*"));
                parent.findElement(By.xpath(".//div//div")).click();


                parent.findElement(By.xpath(".//div[2]//div[2]")).click();


                List<WebElement> contact=parent.findElements(By.xpath("//ul[@class='ui-dropdown-options ui-corner-bottom']/li/a"));
                // System.out.println(li_All.size());
                for (WebElement elementContact : contact) {
                    System.out.println("elementContact est "+elementContact.getText());
                    if (elementContact.getText().equals(parametre)) {
                        scroll(elementContact, driver);
                        elementContact.click();
                        break;
                    }
                }

           break;
            } else {

                System.out.println(status + "not displayed");
            }

        }
    }




    public void TransferCallToExternal(String status,String parametre) throws InterruptedException{
        transfer.click();
        Custom.click();
        List<WebElement> li_All=driver.findElements(By.xpath("//div[@class='row-with-switcher']/label"));
        for (WebElement element : li_All) {
            System.out.println("element est " + element.getText());
            if (element.getText().equals(status)) {
                WebElement parent=element.findElement(By.xpath(".//parent::*//parent::*"));
                parent.findElement(By.xpath(".//div//div")).click();
                parent.findElement(By.xpath(".//div[2]//div[1]")).click();
                List<WebElement> contact=parent.findElements(By.xpath("//ul[@class='ui-dropdown-options ui-corner-bottom']/li/a"));
                // System.out.println(li_All.size());
                for (WebElement elementContact : contact) {
                    System.out.println("elementContact est "+elementContact.getText());
                    if (elementContact.getText().equals("Numéro externe")) {
                        scroll(elementContact, driver);
                        elementContact.click();
                        break;
                    }
                }

                parent.findElement(By.xpath(".//input[@data-role='external-number']")).sendKeys(parametre);
                break;


            } else {

                System.out.println(status + "not displayed");
            }

        }

    }

    public void callBarring(String parameter, String profile){
        List<WebElement> li_All=driver.findElements(By.xpath("//div[@class='row']/label[@class='label']"));
        for (WebElement row : li_All) {
            System.out.println("element est " + row.getText());
            if (row.getText().contains(parameter)) {
                System.out.println("element est " + row.getText());
                WebElement parent=row.findElement(By.xpath(".//parent::*"));
                parent.findElement(By.xpath(".//div")).click();

                if (row.getText().equals("Profil personnalisé")) {
                    driver.findElement(By.xpath("//span[@id='select2-UserCallBarringProfile-container']")).click();

                    List<WebElement> contact=parent.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
                    // System.out.println(li_All.size());
                    for (WebElement elementContact : contact) {
                        System.out.println("elementContact est " + elementContact.getText());
                        if (elementContact.getText().equals(profile)) {
                            scroll(elementContact, driver);
                            elementContact.click();
                            break;
                        }
                    }

                }
            } else {

                System.out.println(parameter + "not displayed");
            }
        }
    }



    public void Simpleuer(String FName,String LName , String number) throws IOException, InterruptedException{
        option(FName,LName,number);
        Next.click();
        Next.click();
        validateuser();
    }

    public void USerWithforwardexternal(String FName,String LName , String contact, String number) throws InterruptedException, IOException{
        option(FName,LName,number);
        TransferCallToExternal("Toujours",contact);
        Next.click();
        Next.click();
        validateuser();
    }


    public void USerWithforwardcontact(String FName,String LName , String contact, String number) throws InterruptedException, IOException{
        option(FName,LName,number);
        TransferCallToContact("Toujours",contact);
        Next.click();
        Next.click();
        validateuser();
    }

    public void USerWithBarring(String FName,String LName , String contact, String number) throws IOException, InterruptedException{
        option(FName,LName,number);
        Next.click();
        callBarring("Profil personnalisé",contact);
        Next.click();
        Next.click();
        validateuser();

    }



    public void validateuser() throws IOException{

        if(isElementDisplayed(dialog)){
            System.out.println( dialog.findElement(By.xpath("//div[2]/div[2]/div")).getText());
            logger.log(Status.PASS,dialog.findElement(By.xpath("//div[2]/div[2]/div")).getText() );
            dialog.findElement(By.xpath("//div[2]/div[2]/div[2]/button")).click();}

        else {
            logger.log(Status.FAIL, error.getText());
            ExtentReportsManager.getscreenshot( driver,logger);

        }

    }
}


