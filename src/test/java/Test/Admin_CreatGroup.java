package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class Admin_CreatGroup extends  STW{

@FindBy(xpath="//a[@class='menuTab-normal stw-main-menu-groups']")
    WebElement Groupe;

@FindBy(id="group-create")
        WebElement CreatBtn;
@FindBy(id="group-name")
        WebElement GroupName;
@FindBy(xpath="//div[@class='search-bar']/input")
        WebElement SearchUser;
@FindBy(xpath="//div[@class='assign-arrow']")
        WebElement assign_arrow;
@FindBy(id="next-button")
        WebElement next ;


    @FindBy(id="save-button")
    WebElement save ;
    @FindBy(xpath="//div[@class='company-widgets-notifications-area']")
    WebElement error;
    @FindBy(id="search-group")
            WebElement searchGp;
    @FindBy(xpath="//button[@class='trash-button enabled']")
            WebElement DeleteBtn;
    @FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-front ui-draggable']")
    WebElement dialog;
    @FindBy(id="group-edit")
            WebElement EditBtn;

    WebDriver driver;
    ExtentTest logger;
  //  ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);



    public Admin_CreatGroup(WebDriver driver, ExtentTest logger, String title, String description  ) {

        super(driver,logger);
    }


    public void CreatGroup(String groupName, String user1 , String user2) throws InterruptedException, IOException{
        isElementDisplayed(Groupe);
        Groupe.click();
        isElementDisplayed(CreatBtn);
        CreatBtn.click();
        GroupName.sendKeys(groupName);
        AddUser(user1);
        assign_arrow.click();
        AddUser(user2);
        next.click();
        save.click();

        if (error.getText().contains("Le nom défini est déjà utilisé pour un groupe de votre organisation. Veuillez définir un nom différent.")){
            System.out.println(error.getText());
            logger.log(Status.FAIL, error.getText());
            ExtentReportsManager.getscreenshot( driver,logger);
        }
        else{
            logger.log(Status.PASS, error.getText());

        }

    }




    public void AddUser(String Name) throws InterruptedException, IOException{
        SearchUser.sendKeys(Name);
        Thread.sleep(3000);
        List<WebElement> li_All=driver.findElements(By.xpath("//div[@class='name-block']/label"));
        for (WebElement element : li_All) {
            if (element.getText().equals(Name)) {
                String cheked = element.findElement(By.xpath(".//parent::*//parent::*//div/div/span")).getAttribute("class");
                System.out.println("element est "+cheked);
                if (cheked.equals("unchecked stw-unchecked")){
                element.findElement(By.xpath(".//parent::*//parent::*//div")).click();
                    logger.log(Status.PASS, "user is  cheked ");
                }else {

                    logger.log(Status.FAIL, "user is already cheked ");
                    ExtentReportsManager.getscreenshot( driver,logger);
            }

                break;
            }

        }
        assign_arrow.click();
    }

    public void Search(String parametre) throws InterruptedException, IOException{
        Thread.sleep(5000);
        isElementDisplayed(Groupe);
        Groupe.click();
        searchGp.sendKeys(parametre);
        Thread.sleep(3000);
        List<WebElement> li_All=driver.findElements(By.xpath("//div[@class='group-item-name-container']/div/span"));

        for (WebElement element : li_All) {
            System.out.println("element est "+element.getText());
            if (element.getText().equals(parametre)) {
                element.findElement(By.xpath(".//parent::*//parent::*")).click();
                logger.log(Status.PASS, "Group is displayed ");
                break;

            }
            else{
                logger.log(Status.FAIL, "Group is not displayed ");
                ExtentReportsManager.getscreenshot( driver,logger);

            }
        }
}

    public void Delete(String parametre) throws InterruptedException, IOException{
        Search(parametre);
        DeleteBtn.click();
        isElementDisplayed( dialog.findElement(By.xpath("//div[3]/div[2]/button")));
        System.out.println("element est "+dialog.getText());
        Thread.sleep(3000);
        dialog.findElement(By.xpath(".//div[3]/div[2]/button")).click();
        logger.log(Status.PASS, error.getText());
}



    public void Edit(String parametre,String user) throws InterruptedException, IOException{
        Search(parametre);
        EditBtn.click();
        AddUser(user);
        next.click();
        save.click();
        Thread.sleep(3000);
        dialog.findElement(By.xpath(".//div[3]/div[2]/button")).click();
        logger.log(Status.PASS, error.getText());
}

}
