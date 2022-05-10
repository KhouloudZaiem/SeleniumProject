package Test;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class MyBusniess extends  STW{
    @FindBy(xpath="//div[@class='tabs-content']/a[2]")
    WebElement myBusniessBTN;
    @FindBy(id="create-process-button")
    WebElement processBTN;
    @FindBy(id="myb-edit-process-details-name-field")
    WebElement processName;
    @FindBy(xpath="//Button[@class='next sw-button']")
    WebElement next;
    @FindBy(xpath="//div[@class='add-section sw-button']")
    WebElement addStep;
    @FindBy(xpath="//div[@class='stw-confirm']")
    WebElement confirm;
    @FindBy(id="edit-form-step-work-flow-myb-process-section-field")
    WebElement stepName;

    @FindBy(xpath="//div[@class='stw-icon stw-widget-address']")
    WebElement adress;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-barcode']")
    WebElement barcode;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-callprocess']")
    WebElement callprocess;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-contact']")
    WebElement contact;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-currency']")
    WebElement currency;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-date']")
    WebElement date;

    @FindBy(xpath="//div[@class='stw-icon stw-widget-doodle']")
    WebElement doodle;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-email']")
    WebElement email;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-html']")
    WebElement html;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-number']")
    WebElement number;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-phonenumber']")
    WebElement phonenumbber;

    @FindBy(xpath="//div[@class='stw-icon stw-widget-qrcode']")
    WebElement qrcode;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-selector']")
    WebElement selector;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-signature']")
    WebElement signature;
    @FindBy(xpath="//div[@class='stw-icon stw-widget-file']")
    WebElement file;
    @FindBy(xpath="//input[@accept='.jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|images/*']")
    WebElement uploadFile;

    @FindBy(xpath="//div[@class='mybusiness-modal-content']/div/div[4]/button[2]")
    WebElement save;
    @FindBy(xpath="//div[@role='dialog']/div[2]/div[3]/div/button")
    WebElement Ok;







    WebDriver driver;
    ExtentTest logger;
 ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    public MyBusniess(WebDriver driver, ExtentTest logger){
        super(driver, logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }

    public void myBusinessTab() throws InterruptedException{
        Thread.sleep(15000);
        isElementDisplayed(myBusniessBTN);
        myBusniessBTN.click();
        Thread.sleep(5000);

    }

    public void createProcess(String name) throws InterruptedException, IOException{

        myBusinessTab();

        processBTN.click();
        Thread.sleep(5000);
        processName.sendKeys(name);
        next.click();
        addStep.click();
        stepName.sendKeys("Step 1");
        confirm.click();
        next.click();
        checkWidget();
        dragAnddrop(adress);
        dragAnddrop(doodle);
        addDoodle();
        dragAnddrop(barcode);
        dragAnddrop(callprocess);
        dragAnddrop(contact);
        dragAnddrop(currency);
        dragAnddrop(number);
       // dragAnddrop(qrcode);
        dragAnddrop(phonenumbber);
        dragAnddrop(date);
        dragAnddrop(html);
        next.click();
        next.click();
        next.click();
        Ok.click();

    }

    public void checkWidget() throws IOException{
        CheckDisplayedOfElement(adress,"Adress");
        CheckDisplayedOfElement(barcode,"BarCode");
        CheckDisplayedOfElement(callprocess,"Call Process");
        CheckDisplayedOfElement(contact,"Contact");
        CheckDisplayedOfElement(currency,"Currency");
        CheckDisplayedOfElement(date,"Date and Time");
        CheckDisplayedOfElement(doodle,"Doodle");
        CheckDisplayedOfElement(email,"E-mail");
        CheckDisplayedOfElement(html,"HTML");
        CheckDisplayedOfElement(number,"Number");
        CheckDisplayedOfElement(phonenumbber,"Phone Number");
        CheckDisplayedOfElement(qrcode,"QR Code");
        CheckDisplayedOfElement(selector,"Selector");
        CheckDisplayedOfElement(signature,"Signature");
        CheckDisplayedOfElement(file,"Upload File");

    }

    public void addDoodle() throws InterruptedException{
        List<WebElement> widgetsLabel=driver.findElements(By.xpath("//div[@class='info']"));


        for (WebElement label : widgetsLabel) {

            WebElement edit= label.findElement(By.xpath(".//parent::*/div[4]/span"));
            if (label.getText().equals("Doodle")){
            System.out.println("label est " + label.getText());
            edit.click();
            uploadFile.sendKeys("/Users/macbookpro/Downloads/fleur.jpg");
            Thread.sleep(5000);
            save.click();
            }
        }
    }

}
