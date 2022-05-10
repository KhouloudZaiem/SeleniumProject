package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class CreateGroupe extends STW {
    WebDriver driver;
    ExtentTest logger;
//    ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[5]/div")
    WebElement Organizations;

    @FindBy(xpath = "/html/body/div/div[1]/section/aside/ul/li[5]/ul/li[3]")
    WebElement Group;
    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div/div[2]/div/input")
    WebElement SelectOrg;

    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div/div[3]/div[1]/div/div/input")
    WebElement SearchGroup;
    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div/div[3]/div[1]/a/button")
    WebElement AddButton;
    @FindBy(xpath="/html/body/div[1]/div[1]/section/main/div[1]/div/div[3]/button[2]")
    WebElement Save;

    @FindBy(xpath="//div[@role='alert']")
    WebElement error;

    @FindBy(xpath="//div[@role='dialog']")
    WebElement dialog;







    public CreateGroupe(WebDriver driver, ExtentTest logger, String title, String description ) {
        super(driver,logger);

    }

    public void GroupTab() throws InterruptedException{
        Thread.sleep(15000);
        Organizations.click();
        Group.click();

    }
public void CreatGroupe(String organisation, String groupName, String departement,String level) throws InterruptedException, IOException{

       GroupTab();
      SearchOrg(SelectOrg,organisation);
     Searchgroup(groupName);
     CreatGP(groupName,departement,departement);
    Save.click();
    if (isElementDisplayed(error)&&(error.getText().contains("The organization group label is already used"))){
        System.out.println("The organization group label is already used");
        logger.log(Status.FAIL, "The organization group label is already used");
        ExtentReportsManager.getscreenshot( driver,logger);
    }

    else{
        logger.log(Status.PASS, "Groupe Created  with sucess ");

    }


}



    public void SearchOrg(WebElement Org, String OrgName) throws InterruptedException{
    Org.sendKeys(OrgName);
     Thread.sleep(1000);
     SelectScroll(OrgName);


}

    public void Searchgroup(String GroupName){
        SearchGroup.sendKeys(GroupName);
        SearchGroup.sendKeys(Keys.RETURN);

            WebElement groupe= driver.findElement(By.xpath("//tr[contains(@class,'l-table__row')]/td[2]/div"));
            isElementDisplayed(groupe);
            System.out.println("element est "+groupe.getText());

            System.out.println("Data is displayed ");



    }

    public void updategroup(String GroupName){
        SearchGroup.sendKeys(GroupName);
        SearchGroup.sendKeys(Keys.RETURN);
        WebElement groupe= driver.findElement(By.xpath("//tr[contains(@class,'l-table__row')]/td[2]/div"));
        isElementDisplayed(groupe);
        if (groupe.getText()==GroupName){
        System.out.println("element est "+groupe.getText());
       groupe.findElement(By.xpath(".//parent::*//parent::*/td[5]/div/a[1]")).click();
    }}

    public void deletgroup(String GroupName) throws InterruptedException{
        SearchGroup.sendKeys(GroupName);
        SearchGroup.sendKeys(Keys.RETURN);
        WebElement groupe= driver.findElement(By.xpath("//tr[contains(@class,'l-table__row')]/td[2]/div"));
        isElementDisplayed(groupe);

            System.out.println("element est "+groupe.getText());
             scroll(groupe.findElement(By.xpath(".//parent::*//parent::*/td[5]/div/button/i")), driver);
             groupe.findElement(By.xpath(".//parent::*//parent::*/td[5]/div/button")).click();
            Thread.sleep(2000);
            dialog.findElement(By.xpath("//div/div[3]/button[1]")).click();
    }




    public void CreatGP(String GroupName, String Dep, String level) throws IOException{

       AddButton.click();
        driver.findElement(By.xpath("//form/div[1]/div/div/input")).sendKeys(GroupName);
        driver.findElement(By.xpath("//form/div[2]/div/div/div/input")) .sendKeys(Dep);
        SelectScroll(Dep);
    System.out.println(  " Departement "+ driver.findElement(By.xpath("//form/div[2]/div/div/div/input")).getText());

        driver.findElement(By.xpath("//div/form/div[5]/div/div/div/input")).click();
        SelectScroll(level);


    }

    public void SelectScroll(String Parametre){
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        // System.out.println(li_All.size());
        for (WebElement element : li_All) {
            //System.out.println("element est "+element.getText());
            if (element.getText().contains(Parametre)) {
                scroll(element, driver);
                element.click();
                break;
            }
        }
    }




}
