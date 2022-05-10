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

public class CreateResellers extends STW {
    WebDriver driver;
    ExtentTest logger;
    //ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    @FindBy(xpath="/html/body/div/div[1]/section/aside/ul/li[4]/div")
    WebElement resellers;
    @FindBy(xpath="/html/body/div/div[1]/section/aside/ul/li[4]/ul/li[1]")
    WebElement allResellers;
    @FindBy(xpath="//a[@class='stw-add']")
    WebElement addresellers;

    @FindBy(xpath="//form/div[1]/div[2]/div[1]/div/div[1]/input")
    WebElement resellersCompanyName;
    @FindBy(xpath="//form/div[1]/div[2]/div[3]/div/div[1]/input")
    WebElement billingsAdr;
    @FindBy(xpath="//form/div[1]/div[2]/div[4]/div/div[1]/input")
    WebElement city;
    @FindBy(xpath="//form/div[1]/div[2]/div[5]/div/div[1]/input")
    WebElement zipCode;
    @FindBy(xpath="//form/div[1]/div[2]/div[6]/div/div/div/input")
    WebElement country;

    @FindBy(xpath="//form/div[2]/div[2]/div[1]/div/div[1]/input")
    WebElement firstName;
    @FindBy(xpath="//form/div[2]/div[2]/div[2]/div/div[1]/input")
    WebElement lastName;
    @FindBy(xpath="//form/div[2]/div[2]/div[3]/div/div[1]/input")
    WebElement phoneNumber;
    @FindBy(xpath="//form/div[2]/div[2]/div[4]/div/div[1]/input")
    WebElement email;

    @FindBy(xpath="//form/div[3]/div[2]/div[1]/div/div[1]/input")
    WebElement firstNameSale;
    @FindBy(xpath="//form/div[3]/div[2]/div[2]/div/div[1]/input")
    WebElement lastNameSale;
    @FindBy(xpath="//form/div[3]/div[2]/div[3]/div/div[1]/input")
    WebElement phoneNumberSale;
    @FindBy(xpath="//form/div[3]/div[2]/div[4]/div/div[1]/input")
    WebElement emailSale;


    @FindBy(xpath="//form/div[5]/div[2]/div[1]/div/div[1]/input")
    WebElement firstNameContact;
    @FindBy(xpath="//form/div[5]/div[2]/div[2]/div/div[1]/input")
    WebElement lastNameContact;
    @FindBy(xpath="//form/div[5]/div[2]/div[3]/div/div[1]/input")
    WebElement phoneNumberContact;
    @FindBy(xpath="//form/div[5]/div[2]/div[4]/div/div[1]/input")
    WebElement emailContact;

    @FindBy(xpath="//form/div[6]/div[2]/div[1]/div/div[1]/input")
    WebElement firstNameAdmin;
    @FindBy(xpath="//form/div[6]/div[2]/div[2]/div/div[1]/input")
    WebElement lastNameAdmin;
    @FindBy(xpath="//form/div[6]/div[2]/div[3]/div/div[1]/input")
    WebElement phoneNumberAdmin;
    @FindBy(xpath="//form/div[6]/div[2]/div[4]/div/div[1]/input")
    WebElement emailAdmin;

    @FindBy(xpath="//form/div[7]/div[2]/div[7]/div/div[1]")
    WebElement broadcastCall;
    @FindBy(xpath="//form/div[7]/div[2]/div[8]/div/div")
    WebElement videoCall;
    @FindBy(xpath="//form/div[7]/div[2]/div[9]/div/div")
    WebElement callPBX;
    @FindBy(xpath="//form/div[7]/div[2]/div[15]/div/div")
    WebElement videostreaming;
    @FindBy(xpath="//form/div[7]/div[2]/div[19]/div/div")
    WebElement myBusniess;


    @FindBy(xpath="//button[text()='Save']")
    WebElement saveBtn;
    @FindBy(xpath="//div[@class='el-notification right']")
    WebElement error;
    @FindBy(xpath="//span[text()='No Data']")
    WebElement noData;
@FindBy(xpath="/html/body/div/div[1]/section/main/div[1]/div[2]/div[1]/div/div/input")
WebElement search;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[7]/div/a[1]")
    WebElement editBtn;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[7]/div/button[1]")
    WebElement connectBtn;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[7]/div/a[2]")
    WebElement detailBtn;
    @FindBy(xpath="//table[@class='el-table__body']/tbody/tr/td[7]/div/button[2]")
    WebElement deleteBtn;
    @FindBy(xpath="//div[@class='el-message-box']")
    WebElement dialog;
    @FindBy(xpath="//div[@class='el-message-box']/div[3]/button[2]")
    WebElement OK;
    @FindBy(xpath="//div[@class='el-message-box']/div[3]/button[1]")
    WebElement cancel;
    public CreateResellers(WebDriver driver, ExtentTest logger, String title, String description ){
        super(driver, logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }


    public void resellersTab() throws InterruptedException{
        Thread.sleep(15000);
    resellers.click();
        Thread.sleep(3000);
      allResellers.click();

    }

    public void create(String name,String billingValue,String cityvalue,String zipcodevalue,String countryvalue,
                       String FNRE, String LNRE,String PNRE,String ERE,
                       String FNRS,String LNRS,String PNRS,String ERS,
                       String FNSC, String LNSC,String PNSC,String ESC,
                       String FNSA, String LNSA,String PNSA,String ESA) throws IOException, InterruptedException{
        resellersTab();
        addresellers.click();
        Thread.sleep(3000);
        resellersCompanyName.sendKeys(name);
        billingsAdr.sendKeys(billingValue);
        city.sendKeys(cityvalue);
        zipCode.sendKeys(zipcodevalue);
        country.sendKeys(countryvalue);
        Thread.sleep(3000);
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        for (WebElement element : li_All) {
            if (element.getText().contains(countryvalue)) {
                element.click();
                break;
            }
        }

        firstName.sendKeys(FNRE);
        lastName.sendKeys(LNRE);
        phoneNumber.sendKeys(PNRE);
        email.sendKeys(ERE);

        firstNameSale.sendKeys(FNRS);
        lastNameSale.sendKeys(LNRS);
        phoneNumberSale.sendKeys(PNRS);
        emailSale.sendKeys(ERS);


        firstNameContact.sendKeys(FNSC);
        lastNameContact.sendKeys(LNSC);
        phoneNumberContact.sendKeys(PNSC);
        emailContact.sendKeys(ESC);

        firstNameAdmin.sendKeys(FNSA);
        lastNameAdmin.sendKeys(LNSA);
        phoneNumberAdmin.sendKeys(PNSA);
        emailAdmin.sendKeys(ESA);

        saveBtn.click();
        CheckError(error,"Resellers");
        chek();

    }
    public void Search(String name) throws IOException, InterruptedException{
        resellersTab();
        search.sendKeys(name);
        search.sendKeys(Keys.RETURN);
        if (isElementDisplayed(error) || isElementDisplayed(noData)){
            Thread.sleep(3000);
            if (isElementDisplayed(noData)){ logger.log(Status.FAIL, "No Data");}
            else {  logger.log(Status.FAIL, error.getText());}
            ExtentReportsManager.getscreenshot( driver,logger);
        }
        else{
            logger.log(Status.PASS, "Resellers  is displayed");


        }

    }


    public void checkelement() throws IOException{
        CheckDisplayedOfElement(addresellers, "Add resellers button ");
        CheckDisplayedOfElement(editBtn, "Edit resellers button ");
        CheckDisplayedOfElement(connectBtn, "Connect resellers button ");
        CheckDisplayedOfElement(detailBtn, "Detail resellers button ");
        CheckDisplayedOfElement(deleteBtn, "Delete resellers button ");
    }

    public void editResellers() throws InterruptedException, IOException{
        editBtn.click();
        Thread.sleep(3000);
        isElementDisplayed(broadcastCall);
        scrollFromElementToAnother(broadcastCall,driver);
        ActiveOption(broadcastCall,"Brodcast call");
        DeactiveOption(videoCall,"Video call");
        DeactiveOption(callPBX , "Call out via PBX");
        ActiveOption(videostreaming,"Video Streming ");
        ActiveOption(myBusniess,"My bussniess ");
        saveBtn.click();
        CheckError(error,"Resellers");
        chek();
    }

    public void deletResellers() throws IOException{

        deleteBtn.click();
        isElementDisplayed(dialog);
        CheckDisplayedOfElement(OK,"OK button");
        CheckDisplayedOfElement(cancel,"cancel button");
        OK.click();

    }



    }
