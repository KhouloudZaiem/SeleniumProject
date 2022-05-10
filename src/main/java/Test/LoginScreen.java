package Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginScreen extends STW  {
    WebDriver driver;
    ExtentTest logger;
    ExtentReportsManager extentReportsManager=new ExtentReportsManager(driver,logger);


    @FindBy(xpath = ("//form/div[1]/div/div/input"))
    WebElement login;
    @FindBy(xpath = ("//input[@type='password']"))
    WebElement password;

    @FindBy(id="login-button")
    WebElement connectBtn ;
    @FindBy(xpath = "/html/body/div[2]")
    WebElement erreur;


    public LoginScreen(WebDriver driver,     ExtentTest logger) {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }


public void checkelement() throws IOException{

    CheckDisplayedOfElement(login,"login");
    CheckDisplayedOfElement(password,"password");
    CheckDisplayedOfElement(connectBtn,"Connect button ");

}



    public void connect(String pass, String mail) throws IOException{

        login.sendKeys(mail);
        password.sendKeys(pass);
        connectBtn.click();
        if(isElementDisplayed(erreur)&& (erreur.getText().contains("The provided credentials are incorrect"))){
            System.out.println(erreur.getText());
           logger.log(Status.FAIL, "Admin not connected with succes");
            ExtentReportsManager.getscreenshot( driver,logger);

        }
        else{
            System.out.println(driver.getTitle());
         logger.log(Status.PASS, "Admin connected with succes  with sucess ");

        }


    }




}
