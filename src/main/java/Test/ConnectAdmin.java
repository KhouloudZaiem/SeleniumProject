package Test;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConnectAdmin extends STW {

    WebDriver driver;
    ExtentTest logger;
    //ExtentReportsManager extentReportsManager=new ExtentReportsManager(driver,logger);

    @FindBy(xpath = "//button[@class='el-button el-tooltip el-button--text'][1]")
    WebElement ConnectBtn;
    @FindBy(xpath = "//div[@class='settings-menu']")
    WebElement SettingMenu;
    @FindBy(id = "settings")
    WebElement Setting;



    public ConnectAdmin(WebDriver driver , ExtentTest logger, String title, String description) {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }

    public void Admin() throws InterruptedException {
       Thread.sleep(3000);
        ConnectBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until((ExpectedConditions.numberOfWindowsToBe(2)));

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        driver.switchTo().window(windowHandlesList.get(1));
        System.out.println(driver.getTitle());
        Thread.sleep(9000);
      // SettingMenu.click();
       // Setting.click();

    }

}
