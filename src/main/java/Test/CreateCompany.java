package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class CreateCompany extends STW {
    WebDriver driver;
    ExtentTest logger;
   ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[5]/div")
    WebElement Organizations;

    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[5]/ul/li[1]")
    WebElement All;
    @FindBy(xpath = "//input[@class='el-input__inner']")
    WebElement search;


    @FindBy(xpath = "/html/body/div[3]")
    WebElement erreur;
    @FindBy(xpath="//div[2]/div[1]/a/button")
    WebElement AddButton;

    @FindBy(xpath="//input[@class='el-input__inner']")
    WebElement CompanyName;
    @FindBy(xpath="//section/main/div[1]/div/div[2]/form")
    WebElement frame;
    @FindBy(xpath="//form/div[1]/div[2]/div[3]/div/div/div/input")
    WebElement TimeZone;
    @FindBy(xpath="//form/div[1]/div[2]/div[2]/div/div/div/input")
    WebElement RE;
    @FindBy(xpath="//main/div[1]/div/div[2]/form/div[1]/div[2]/div[4]/div/div/input")
    WebElement adress;
    @FindBy(xpath="//input[@placeholder='Pick a day']")
    WebElement DateExpiration;
    @FindBy(xpath="/html/body/div[4]/div[1]/div/div[1]/span[1]")
    WebElement yearValue;

    @FindBy(xpath="/html/body/div[4]/div[1]/div/div[1]/span[2]")
    WebElement monthValue;

    @FindBy(xpath="//form/div[3]/div[2]/div[1]/div/div/input")
    WebElement FirstName;
    @FindBy(xpath="//form/div[3]/div[2]/div[2]/div/div/input")
    WebElement LastName;

   @FindBy(xpath="//form/div[3]/div[2]/div[3]/div/div/input")
   WebElement E_mail;
   @FindBy(xpath="//form/div[6]/div[2]/div[2]/div/div/span")
 WebElement NewAppVersion;
  @FindBy(xpath="//form/div[6]/div[2]/div[1]/div/div/span")
   WebElement LargeOrganisation;
@FindBy(xpath="//form/div[5]/div[2]/div[1]/div/div/div")
WebElement MAxUser;
   @FindBy(xpath="//form/div[5]/div[2]/div[2]/div/div/div")
   WebElement MAxGroup;





   @FindBy(xpath="//form/div[6]/div[2]/div[4]/div/div/div/input")
    WebElement PublicVisiblity ;
    @FindBy(xpath="//form/div[6]/div[2]/div[18]/div/div[1]")
    WebElement WebChat;
     @FindBy (xpath="//form/div[6]/div[2]/div[18]/div/div[2]/div[1]/div[1]")
     WebElement WebChatStatus;

     @FindBy(xpath="//form/div[6]/div[2]/div[6]/div/div[1]/input")
     WebElement OperationStatus;
     @FindBy(xpath="//form/div[6]/div[2]/div[20]/div/div[1]")
     WebElement Call;
    @FindBy (xpath=" //form/div[6]/div[2]/div[20]/div/div[2]/div/div[1]")
    WebElement CallStatus;
    @FindBy(xpath="//form/div[6]/div[2]/div[20]/div/div[3]/div")
    WebElement CallForward;
    @FindBy(xpath="//form/div[6]/div[2]/div[20]/div/div[4]/div")
    WebElement CallTransfer;
    @FindBy(xpath="//form/div[6]/div[2]/div[20]/div/div[5]/div")
    WebElement CallBarring;
    @FindBy(xpath="//form/div[6]/div[2]/div[20]/div/div[6]/div")
    WebElement CallVoiceMail;

    @FindBy(xpath="//form/div[6]/div[2]/div[21]/div/div[1]")
    WebElement CellularCall;

    @FindBy(xpath=" //form/div[6]/div[2]/div[21]/div/div[2]/div/div/input")
    WebElement CellularCallStatus;

    @FindBy(xpath="//form[1]/div[6]/div[2]/div[22]/div[1]/div[1]/div[1]")
    WebElement ConfereneCall;
    @FindBy(xpath=" //form/div[6]/div[2]/div[23]/div/div[2]/div[1]/div[1]")
    WebElement PTT;
    @FindBy(xpath="//div[6]/div[2]/div[23]/div/div[2]/div[1]/div[1]")
    WebElement PTTStatus;

    @FindBy(xpath="//form/div[6]/div[2]/div[23]/div/div[2]/div[2]/div[1]")
    WebElement Priorite;
    @FindBy(xpath="//form/div[6]/div[2]/div[23]/div/div[2]/div[2]/div[2]/div/div[1]/div/input")
    WebElement level;
    @FindBy(xpath = "//form/div[6]/div[2]/div[23]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]")
    WebElement Slider;

    @FindBy(xpath="//form/div[6]/div[2]/div[30]/div/div[1]")
    WebElement CallOut;
        @FindBy(xpath="//form/div[6]/div[2]/div[35]/div/div[1]")
    WebElement Geolocalisation;
        @FindBy(xpath="//form/div[6]/div[2]/div[36]/div/div[1]")
        WebElement VideoStreaming;
    @FindBy(xpath="//form/div[6]/div[2]/div[36]/div/div[2]/div[1]/div")
    WebElement StreamingStatus;
    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div/div[2]/form/div[6]/div[2]/div[36]/div/div[2]/div[3]/div")
    WebElement VideoDestination;
    @FindBy(xpath="//form/div[6]/div[2]/div[36]/div/div[2]/div[4]/div")
    WebElement VideoStremingUser;
     @FindBy(xpath="//form/div[6]/div[2]/div[43]/div/div[1]")
     WebElement AllowMyBusniess;

    @FindBy(xpath="//form/div[7]/div[2]/div[4]/div/div[1]")
    WebElement MyBusniess;

     @FindBy(xpath="//button[@class='el-button el-button--primary']")
     WebElement save;
     @FindBy(xpath="//div[@class='el-notification right']")
     WebElement error;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[4]/div/a")
    WebElement editBtn;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[4]/div/button[1]")
    WebElement connectBtn;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[4]/div/button[2]")
    WebElement blockBtn;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[4]/div/button[3]")
    WebElement deleteBtn;
    @FindBy(xpath="//button[text()='Export CSV' and @type='button']")
    WebElement ExportBtn;
@FindBy(xpath="//span[text()='No Data']")
WebElement noData;
    public CreateCompany(WebDriver driver,ExtentTest logger){
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }


public void OrganizationTab() throws InterruptedException{
    Thread.sleep(15000);
    Organizations.click();
    All.click();

}


    public void Search(String idCompany) throws IOException, InterruptedException{
        OrganizationTab();
        search.sendKeys(idCompany);
        search.sendKeys(Keys.RETURN);
        if (isElementDisplayed(error) || isElementDisplayed(noData)){

            if (isElementDisplayed(error)) {
                logger.log(Status.FAIL, error.getText());}

            if (isElementDisplayed(noData)){
                logger.log(Status.FAIL, "No Data");}

            ExtentReportsManager.getscreenshot( driver,logger);
        }
        else{
            logger.log(Status.PASS, "Company is displayed");


        }

    }

    public void checkelement() throws IOException{
        CheckDisplayedOfElement(AddButton,"Add company button ");
       CheckDisplayedOfElement(editBtn,"Edit company button ");
       CheckDisplayedOfElement(connectBtn,"Connect company button ");
       CheckDisplayedOfElement(blockBtn,"Block company button ");
        CheckDisplayedOfElement(deleteBtn,"Delete company button ");
        CheckDisplayedOfElement(ExportBtn,"Export CSV company button ");

    }

    public void AddCompany(String companyName, String resealler, String firstName, String lastName,String email,int nbUser ,int nbGroup ) throws InterruptedException, IOException{

        OrganizationTab();
        AddButton.click();
        WebDriverWait wait=new WebDriverWait(driver, 2);
        wait.until((ExpectedConditions.visibilityOf(frame))).isDisplayed();
       CompanyName.sendKeys(companyName);
        RE.sendKeys(resealler);
        Thread.sleep(3000);
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        for (WebElement element : li_All) {
            if (element.getText().contains(resealler)) {
                element.click();
                break;
            }
        }

        TimeZone.sendKeys("West");
        for (WebElement listTime : li_All) {
            if (listTime.getText().contains("(UTC+01:00) West Central Africa")) {
                listTime.click();
                break;
            }
        }

        scrollFromElementToAnother(DateExpiration,driver);
         SelectDate("2025","Mar","16");
        STW.scrollFromElementToAnother(FirstName,driver);
        FirstName.sendKeys(firstName);
        LastName.sendKeys(lastName);
        E_mail.sendKeys(email);
        EditNumber(nbGroup,MAxUser);
        System.out.println("value is" +MAxGroup.getAttribute("aria-valuenow"));
        EditNumber(nbGroup,MAxGroup);
        selectStatus(PublicVisiblity,"Active");
        scrollToElementCenter(WebChat,driver);
        ActiveOption(WebChat,"Web Chat ");
        isElementDisplayed(WebChatStatus);
        selectStatus(WebChatStatus,"Inactive");
       ActiveOption(Call,"Call");
        selectStatus(CallStatus,"Active");
        Thread.sleep(2000);
        ActiveOption(CallForward,"Call Forward");
        DeactiveOption(CallTransfer,"Call transfer");
        ActiveOption(CallBarring,"Call barring");
        ActiveOption(CallVoiceMail,"Call Voice Mail");
        ActiveOption(CellularCall,"CEllular Call");
        ActiveOption(ConfereneCall,"Conference Call");
        scrollFromElementToAnother(PTT,driver);
        ActiveOption(PTT,"Push to talk call");
        selectStatus(PTTStatus,"Active");
        ActiveOption(Priorite,"Priorite");
        moveSliderToEnd(Slider,50,driver);
        ActiveOption(CallOut,"Call Out");
        ActiveOption(Geolocalisation,"Geoloction");
        ActiveOption(VideoStreaming,"Video Streaming");
        selectStatus(StreamingStatus,"Active");
        selectStatus(VideoDestination,"Active");
        EditNumber(108,VideoStremingUser);
       ActiveOption(MyBusniess,"My Busniess");
        save .click() ;
        CheckError(error, "Organisation");
        chek();



    }


    public void editCompany() throws InterruptedException{
        OrganizationTab();
        //edit button
      //  EditNumber();
        save .click();

    }

    public void deleteCompany() throws InterruptedException{
        OrganizationTab();
        //delet button
        //  EditNumber();

    }






    public void SelectDate(String year, String month, String day) throws InterruptedException{

        DateExpiration.click();
        Thread.sleep(3000);

        while (true) {
            String YYYY=yearValue.getText();

            if (YYYY.equals(year)) {

                break;
            } else {
                driver.findElement(By.xpath("//button[@aria-label='Next Year']")).click();
            }
        }
        Thread.sleep(2000);
        monthValue.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='el-month-table']/tbody/tr/td/div/a[contains(text(),'"+month+"')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@class='el-date-table__row']/td/div/span[text()="+day+"]")).click();

    }










    }





















