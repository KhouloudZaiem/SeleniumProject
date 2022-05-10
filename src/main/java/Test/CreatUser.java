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

public class CreatUser extends  STW{
  public   WebDriver driver;
    ExtentTest logger;
   // ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[5]/div")
     WebElement Organizations;
    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[8]")
    WebElement User;
    @FindBy(xpath="//span[@class='vti__selection']")
    WebElement Flag;
    @FindBy(xpath="//input[@name='telephone']")
    WebElement number;

    @FindBy(xpath="//form/div[1]/div[2]/div/div[1]/div[2]/div/div/input")
    WebElement FirstName;

    @FindBy(xpath="//form/div[1]/div[2]/div/div[1]/div[3]/div/div/input")
    WebElement LastName;

    @FindBy(xpath="//form/div[2]/div[2]/div/div/div/span")
    WebElement LinkOrg;
    @FindBy(xpath="  //form/div[3]/div[2]/div/div[1]/div/div/div/input")
    WebElement Org;

@FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div[2]/button[2]")
WebElement Save;


    @FindBy(xpath="/html/body/div[4]")
    WebElement error;

    @FindBy(xpath="/html/body/div/div[1]/section/main/div[1]/div[2]/div[1]/div/div/input")
    WebElement SearchUser;
    @FindBy(xpath="//form/div[1]/div[2]/div/div[1]/div[4]/div/div")
    WebElement AllowCall;
    @FindBy(xpath="/html/body/div/div[1]/section/main/div[1]/div[2]/form/div[2]/div[2]/div[3]/div[9]/div/div")
    WebElement xx;
    @FindBy(xpath="//div[@role='dialog']")
    WebElement dialog;

    public CreatUser(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;

    }



    public void UserTab() throws InterruptedException{
        Thread.sleep(15000);
        Organizations.click();
        User.click();

    }



    public  void CreateUser(String flag, String Number, String Name, String Lastname, String org) throws InterruptedException, IOException{
        UserTab();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/main/div[1]/div[2]/div[1]/a/button")).click();
        isElementDisplayed(Flag);
        Flag.click();
        FlagScroll(flag);
        number.sendKeys(Number);
        FirstName.sendKeys(Name);
        LastName.sendKeys(Lastname);
        LinkOrg.click();
       Thread.sleep(3000);
        Org.sendKeys(org);
        SelectScroll(org);
        Thread.sleep(3000);
        TransferPanel("DEP Hamza");
        Save.click();


        if (isElementDisplayed(error)){
            System.out.println(error.getText());
            logger.log(Status.FAIL, error.getText());
            ExtentReportsManager.getscreenshot( driver,logger);
        }

        else{
            logger.log(Status.PASS, "User Created  with sucess ");

        }
    }



    public void FlagScroll(String Parametre){
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='vti__dropdown-list below']/li/span"));
        for (WebElement element : li_All) {
            if (element.getText().contains(Parametre)) {
                element.click();
                break;
            }
        }
    }

    public void SelectScroll(String Parametre){
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        for (WebElement element : li_All) {
            if (element.getText().contains(Parametre)) {
                element.click();
                break;
            }
        }
    }



    public void TransferPanel(String Parametre){
        WebElement Element=driver.findElement(By.xpath("//label[contains(@class,'el-checkbox el-transfer-panel__item')]/span[2]/span"));

            if (Element.getText().equals(Parametre)) {
                WebElement Parent= Element.findElement(By.xpath(".//parent::*//parent::*"));
                Parent.click();
                driver.findElement(By.xpath("//div[@class='el-transfer__buttons']/button[2]")).click();

            } else {

                System.out.println(Parametre+"is not displayed");
            }


        }

        public void updateuser(String user) throws InterruptedException{

             SearchUser(user);
            driver.findElement(By.xpath("//div[@class='cell']/button[1]")).click();
            Thread.sleep(2000);
            ActiveOption(AllowCall,"Call");
            scrollFromElementToAnother(xx,driver);
            //  DeactiveOption(xx);
        }


    public void deleteuser(String user) throws InterruptedException{


        SearchUser(user);
        driver.findElement(By.xpath("//div[@class='cell']/button[4]")).click();
        Thread.sleep(2000);
         dialog.findElement(By.xpath("//div/div[3]/button[1]")).click();

    }



    public void SearchUser(String parametre ) throws InterruptedException{
        UserTab();
        SearchUser.sendKeys(parametre);
        SearchUser.sendKeys(Keys.RETURN);
        if (isElementDisplayed(driver.findElement(By.xpath("//span[text()='No Data']")))) {

            System.out.println("No Data is displayed ");
        }
        else {

            System.out.println("Data is displayed ");

        }


    }


    }


