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

public class CreateDepartment extends STW {

    WebDriver driver;
    ExtentTest logger;
    ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);
    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[5]/div")
    WebElement organizations;

    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[5]/ul/li[2]")
    WebElement departments;
    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div/div[2]/div/input")
    WebElement organisationName;
    @FindBy(xpath="//i[@class='stw-add']")
    WebElement addBTN;
    @FindBy(xpath="//form/div[1]/div/div/input")
    WebElement departmentName;
    @FindBy(xpath="//form/div[5]/div/div/div/input")
     WebElement departmentLevel;
    @FindBy(xpath="//button[text()='Add']")
    WebElement saveBTN;
    @FindBy(xpath="//div[@class='el-notification right']")
    WebElement error;
    @FindBy(xpath="//span[text()='No Data']")
    WebElement noData;
    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div/div[3]/div[1]/div/div/input")
    WebElement searchDep;

    @FindBy(xpath="//i[@class='stw-delete']")
    WebElement deleteBtn;
    @FindBy(xpath="//div[@class='el-message-box']")
    WebElement dialog;
    @FindBy(xpath="//div[@class='el-message-box']/div[3]/button[2]")
    WebElement OK;
    @FindBy(xpath="//div[@class='el-message-box']/div[3]/button[1]")
    WebElement cancel;

    public CreateDepartment(WebDriver driver, ExtentTest logger){
        super(driver, logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }


    public void departmentTAB() throws InterruptedException{
        Thread.sleep(15000);
        organizations.click();
        departments.click();
    }



    public void CreatDepartment(String orgNAme ,String depName,String level) throws InterruptedException, IOException{
        departmentTAB();
        organisationName.click();
        organisationName.clear();
        organisationName.sendKeys(orgNAme);
        Thread.sleep(3000);
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        for (WebElement element : li_All) {
            if (element.getText().equals(orgNAme)) {
                element.click();
                break;
            }
        }
        addBTN.click();
        departmentName.sendKeys(depName);
        departmentLevel.click();
        List<WebElement> li_All2=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        for (WebElement element : li_All2) {
            if (element.getText().contains(level)) {
                element.click();
                break;
            }
        }
        saveBTN.click();
        CheckError(error,"Departments");
        chek();
    }

    public void serachDepartment(String orgNAme,String name) throws InterruptedException, IOException{
        departmentTAB();
        organisationName.click();
        organisationName.clear();
        organisationName.sendKeys(orgNAme);
        Thread.sleep(3000);
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        for (WebElement element : li_All) {
            if (element.getText().equals(orgNAme)) {
                element.click();
                break;
            }
        }
        searchDep.sendKeys(name);
        searchDep.sendKeys(Keys.RETURN);
        if (isElementDisplayed(error) || isElementDisplayed(noData)){
            Thread.sleep(3000);
            if (isElementDisplayed(noData)){ logger.log(Status.FAIL, "No Data");}
            else {  logger.log(Status.FAIL, error.getText());}
            ExtentReportsManager.getscreenshot( driver,logger);
        }
        else{
            logger.log(Status.PASS, "Department  is displayed");


        }

    }


    public void deletResellers() throws IOException{

        deleteBtn.click();
        isElementDisplayed(dialog);
        CheckDisplayedOfElement(OK,"OK button");
        CheckDisplayedOfElement(cancel,"cancel button");
        OK.click();

    }


}
