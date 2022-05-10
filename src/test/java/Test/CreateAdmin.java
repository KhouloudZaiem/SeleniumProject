package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CreateAdmin extends STW {

    WebDriver driver;
    ExtentTest logger;
 ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    @FindBy(xpath="/html/body/div[1]/div[1]/section/aside/ul/li[3]")
    WebElement AdminAccount;
    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div[2]/div[1]/a/button")
    WebElement Admin;
    @FindBy(xpath="//form/div/div/div/div[1]/div[1]/div/div[1]/input")
    WebElement mail;
    @FindBy(xpath="//form/div/div/div/div[1]/div[2]/div/div[1]/input")
    WebElement FirstName;
    @FindBy(xpath="//form/div/div/div/div[1]/div[3]/div/div[1]/input")
    WebElement LastName;
    @FindBy(xpath="//button[contains(text(), 'Add')]")
     WebElement Add;

    @FindBy(xpath="/html/body/div[4]")
    WebElement error;

    public CreateAdmin(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }



    public void creatAdmin(String email,String firstName,String lastname) throws InterruptedException, IOException{
AdminAccount.click();
Admin.click();
    mail.sendKeys(email);
    FirstName.sendKeys(firstName);
    LastName.sendKeys(lastname);
    Thread.sleep(2000);
    Add.click();
        if (isElementDisplayed(error)){
            System.out.println(error.getText());
            logger.log(Status.FAIL, error.getText());
            ExtentReportsManager.getscreenshot( driver,logger);
        }

        else{
            logger.log(Status.PASS, "User Created  with sucess ");

        }
    }


    public void SearchAdmin(String firstName) throws InterruptedException, IOException{

    }
    public void EditAdmin(String firstName) throws InterruptedException, IOException{

    }
    public void DeletAdmin(String firstName) throws InterruptedException, IOException{

    }
}
