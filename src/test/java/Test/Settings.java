package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class Settings extends  STW{

    @FindBy(xpath="//div[@class='settings-menu']")
        WebElement settingBar;
    @FindBy(xpath="//a[@href='/settings/index']")
        WebElement setting;
    @FindBy(xpath="//form[@id='settings-GlobalOrganizationOperationalStatus-form']/div/table/tbody/tr/td[3]/div/div")
        WebElement OperationSataus;
    @FindBy(xpath="//form[@id='settings-GlobalOrganizationOperationalStatus-form']/div/table/tbody/tr[2]/td/div/div[2]/div[2]/button")
            WebElement editStatus;

        @FindBy(xpath="//div[@role='dialog']")
        WebElement dialog;
    @FindBy(xpath="//input[@id='operational-status-form-label-field']")
            WebElement StatusName;
    @FindBy(xpath="//button[@data-role='add']")
            WebElement add;
    @FindBy(xpath="//input[@data-role='status-code']")
    WebElement codeStatus;
    @FindBy(xpath="//input[@data-role='status-name']")
    WebElement NomStatus;
    @FindBy(xpath="//input[@data-role='status-description']")
    WebElement description;

    @FindBy(xpath="//div[@class='pointer sw-op-status-color']")
    WebElement colorStatus;

    @FindBy(xpath="//button[@data-role='save']")
    WebElement save;


    @FindBy(xpath="//form[@id='settings-CallForwardFeatures-form']/div/table/tbody/tr/td[2]/button")
    WebElement TransferProfile;
    @FindBy(id="call_forward_profile_name")
    WebElement ProfileName;

    @FindBy(xpath="//form[@id='settings-CallForwardFeatures-form']/div/table/tbody/tr[2]/td/div/div/div[1]")
    WebElement ProfileNameEdit;
    @FindBy(xpath="//form[@id='settings-GlobalOrganizationEmergencyAlert-form']/div/table/tbody/tr[1]/td[3]/div/div")
    WebElement StatusEmergencyMSG;
    @FindBy(xpath="//form[@id='settings-GlobalOrganizationEmergencyAlert-form']/div/table/tbody/tr[2]/td[3]/div/button")
    WebElement AddEmergencyMSG;
    @FindBy(xpath="//input[@class='profile-name']")
    WebElement EmergencyName;
    @FindBy(xpath="/html/body/div[8]/div[2]/div[2]/div[2]/div/div[3]")
    WebElement status;

    @FindBy(xpath=" /html/body/div[8]/div[2]/div[3]/div[2]/div[1]/div[2]")
    WebElement Users;
    @FindBy(xpath="//*[@id='ui-id-4']/div[3]/div[3]/div[1]")
    WebElement recipient;

    @FindBy(xpath="//div[@class='vertical-box box-container available-box-container']/div[1]/div[2]/div/div/input")
    WebElement SearchUser;
    @FindBy(xpath=" //div[@class='assign-arrow']")
    WebElement Adduser;

    WebDriver driver;
    ExtentTest logger;
   ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    public Settings(WebDriver driver, ExtentTest logger ){
        super(driver, logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }
    public void SettingTab() throws InterruptedException{
        Thread.sleep(15000);
        isElementDisplayed(settingBar);
        settingBar.click();
        Thread.sleep(5000);
        setting.click();
        Thread.sleep(5000);
    }

    public void changeStatus(String status) throws InterruptedException{

        scrollFromElementToAnother(OperationSataus,driver);
        Thread.sleep(15000);
          OperationSataus.click();
       Thread.sleep(3000);
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@id='dropdownForGlobalOrganizationOperationalStatus']/li/a"));

        if(OperationSataus.findElement(By.xpath(".//input")).getText().equals(status)){
            logger.log(Status.PASS, status +" is already selected ");
            System.out.println(OperationSataus.findElement(By.xpath(".//input")));

        }else{
        for (WebElement element : li_All) {
            System.out.println("element est " + element.getText());
            if (element.getText().equals(status)) {
                isElementDisplayed(element);
                element.click();
                isElementDisplayed(dialog);
                Thread.sleep(5000);
                System.out.println(  driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[2]/label[1]")).getText());
                driver.findElement(By.xpath("//*[@id='confirm']")).click();
                logger.log(Status.PASS, "Status is changed to " + status);
                break;
            }}

        }
}

  public void CreatStatus(String name) throws InterruptedException{
      SettingTab();
    scrollFromElementToAnother(OperationSataus,driver);

    editStatus.click();
    isElementDisplayed(dialog);
    StatusName.clear();
    StatusName.sendKeys(name);
    AddStatus("011","sat1","des");
    save.click();
    logger.log(Status.PASS, "Profile is created " + name);


}
    public void AddStatus(String code,String name,String desc){

        add.click();
        codeStatus.sendKeys(code);
        NomStatus.sendKeys(name);
        description.sendKeys(desc);

  }


public void CreatProfileTransfer(String name,String status,String parametre) throws InterruptedException{


    SettingTab();
    scrollFromElementToAnother(TransferProfile,driver);
    Thread.sleep(5000);
    TransferProfile.click();
    Thread.sleep(5000);
    ProfileName.sendKeys(name);
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
    save.click();
    logger.log(Status.PASS, " transfer Profile  is created " + name);
    // ,String UserA ,String UserB ,String RecA , String RecN

}

public void AddEmergencyMSG (String name,String UserA ,String UserB ,String recA, String recB) throws InterruptedException, IOException{

    SettingTab();
  isElementDisplayed(AddEmergencyMSG);
    AddEmergencyMSG.click();
    Thread.sleep(5000);
    EmergencyName.sendKeys(name);
    Thread.sleep(3000);
    status.click();
    Users.click();
    AddUser(UserA);
    AddUser(UserB);
    Adduser.click();
    recipient.click();
    AddUser(recA);
    AddUser(recB);
}








    public void AddUser(String Name) throws InterruptedException, IOException{
        SearchUser.clear();
        SearchUser.sendKeys(Name);
        SearchUser.sendKeys(Keys.RETURN);
        Thread.sleep(7000);
        List<WebElement> li_All=driver.findElements(By.xpath("//div[@data-role='search-list']/div/div/div[2]/label"));
        for (WebElement element : li_All) {
            System.out.println("element est "+element.getText());
            if (element.getText().equals(Name)) {
                String cheked = element.findElement(By.xpath(".//parent::*//parent::*//div[1]/div/span")).getAttribute("class");
                System.out.println("element est " +cheked);
                if (cheked.contains("checked stw-checked")){
                    element.findElement(By.xpath(".//parent::*")).click();
                   Adduser.click();
                    logger.log(Status.PASS, "user is  cheked ");
                }else {
                    logger.log(Status.FAIL, "user is already cheked ");
                    ExtentReportsManager.getscreenshot( driver,logger);
                }

                break;
            }



        }
    }






}
