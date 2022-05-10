package Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class STW {
    private static final int TIMEOUT=10;
    WebDriver driver;
    ExtentTest logger;
    ExtentReportsManager report;
    //ExtentReportsManager extentReportsManager = new ExtentReportsManager(driver,logger);

    public STW(WebDriver driver, ExtentTest logger) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.logger = logger;
    }




    public  boolean isElementDisplayed(WebElement element){

        try{

            WebDriverWait wait=new WebDriverWait(driver, 2);
            return wait.until((ExpectedConditions.visibilityOf(element))).isDisplayed();

        }catch(Exception e){

            return false;
        }
    }


    public String getAlertText(){
        try{
            Alert alert=driver.switchTo().alert();
            String alertText=alert.getText();
            return alertText;
        }catch(NoAlertPresentException e){
            throw e;
        }
    }

    /* *
     * method to verify if alert is present
     *
     * @return returns true if alert is present else false*/
    public boolean isAlertPresent(){
        try{
            // WebDriverWait wait = new WebDriverWait(mDriver, TIMEOUT);
            // wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            return true;
        }catch(Exception e){
            // throw e;
            return false;
        }
    }

    /**
     * method to Accept Alert if alert is present
     */
    public void acceptAlert(){
        WebDriverWait wait=new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }


    /**
     * method to Dismiss Alert if alert is present
     */

    public void dismissAlert(){
        // WebDriverWait wait = new WebDriverWait(mDriver, TIMEOUT);
        //  wait.until(ExpectedConditions.alertIsPresent());
        if (isAlertPresent())
            driver.switchTo().alert().dismiss();
    }



    public void CheckDisplayedOfElement(WebElement xx, String item) throws IOException {
        if (isElementDisplayed(xx)) {
            logger.log(Status.PASS, item + "  option is displayed ");

        } else {
            logger.log(Status.FAIL, item + "  option is not  displayed ");
            ExtentReportsManager.getscreenshot( driver,logger);
        }
    }



    public static boolean isElementEnabled(WebElement element){

        return element.isEnabled();
    }


    public static void scrollFromElementToAnother(WebElement element, WebDriver driver){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

    }





    public void ActiveOption(WebElement option, String item) throws InterruptedException{
       System.out.println("ccc" +option.getAttribute("class"));
        String aaa = option.getAttribute("class");
            if (aaa.equals("el-switch")) {
                option.click();
                //logger.log(Status.INFO,"active"+item);
                System.out.println(item+"is activeted");
            }
        else {
                System.out.println(item+"is alredy activeted");
            }

    }


    public  void DeactiveOption(WebElement option, String item){
        System.out.println("vvv"+option.getAttribute("class"));

        if (option.getAttribute("class").equals("el-switch") ) {
           // logger.log(Status.INFO,item+"is alredy deactive");
        }

        else   {
            option.click();
//            logger.log(Status.INFO,"Deactive"+item);
        }
    }



    public static void scroll(WebElement element, WebDriver driver){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToElementCenter(WebElement element, WebDriver driver){

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }

    public void moveSliderToEnd(WebElement priceSlider,int value ,WebDriver driver) {

        int newValue=(int) (value * 2.36);
        int   ValueW =priceSlider.getLocation().getX();
       int valueH= priceSlider.getLocation().getY();
        System.out.println("LA valeuue du slidewidth " + ValueW);
        Actions builder=new Actions(driver);

        builder.dragAndDropBy(priceSlider,newValue, 0).release().build().perform();
        priceSlider.click();

                }



    public void EditNumber(int numero, WebElement valueInit){

        WebElement VV=valueInit.findElement(By.xpath(".//input"));
        WebElement parent = valueInit.findElement(By.xpath(".//parent::*"));
        WebElement Ajoue= parent.findElement(By.xpath(".//span[@class='el-input-number__increase']"));
        WebElement diminu= parent.findElement(By.xpath(".//span[@class='el-input-number__decrease']"));

        while (true) {
            String Value=VV.getAttribute("aria-valuenow");
            int a=Integer.parseInt(String.valueOf(Value));
            if (a == numero) {
                break;
            } else {

                if (a < numero) {
                    Ajoue.click();
                } else {
                    diminu.click();
                }


            }
        }
    }



    public  void ActiveOptionRadio(WebElement option){

        String classes = option.findElement(By.xpath(".//span")).getAttribute("class");
        System.out.println("class est "+classes);
        if (classes.equals("ui-checkbox ui-checkbox-checked ui-checkbox-state-checked")) {
            System.out.println("cette option est deja activé "+option);

        }
        else {
            option.click();
        }

    }


    public  void DeactiveOptionRadio(WebElement option){

        String classes = option.findElement(By.xpath(".//span")).getAttribute("class");
        System.out.println("class est "+classes);
        if (classes.equals("ui-checkbox ui-checkbox-checked ui-checkbox-state-checked")) {
            option.click();
        }
        else {
            System.out.println("cette option est deja deactivé "+option);
        }

    }

    public void selectStatus( WebElement webElement ,String  status ) throws InterruptedException{
        webElement.click();
        Thread.sleep(2000);
        List<WebElement> li_All=driver.findElements(By.xpath("//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span"));
        for (WebElement element : li_All) {
            if (element.getText().contains(status)) {
                element.click();
                logger.log(Status.INFO ,webElement.findElement(By.xpath(".//parent::*//parent::*/label")).getText()+ "  is changed to "+status);
                break;
            }

        }


    }

    public void chek() throws IOException{

        List<WebElement> li_All=driver.findElements(By.xpath("//div[@class='el-form-item__error']"));
        for (WebElement element : li_All) {
            if (element.isDisplayed()){
                System.out.println("Error field is "+element.getText());
                logger.log(Status.FAIL,element.getText());
                ExtentReportsManager.getscreenshot( driver,logger);

            }}

    }
    public   void CheckError(WebElement element,String item) throws IOException, InterruptedException{
        Thread.sleep(3000);
        if (isElementDisplayed(element)) {
            logger.log(Status.FAIL,element.getText());
            ExtentReportsManager.getscreenshot( driver,logger);
        }else{
            logger.log(Status.PASS,item+" created with sucees ");
        }


    }
    public void dragAnddrop(WebElement fromElement) throws IOException{
        WebElement toElement=driver.findElement(By.xpath("//div[@class='section-grid-container']"));
    Actions builder = new Actions(driver);

    Action dragAndDrop = builder.clickAndHold(fromElement)
            .moveToElement(toElement)
            .release(toElement)
            .build();
    dragAndDrop.perform();




}


    public static void GetUseCaseDescription(String UseCaseID, int FragmentNumber, ExtentTest mLogger) throws IOException{


        XSSFWorkbook wb= new XSSFWorkbook("/Users/macbookpro/IdeaProjects/SeleniumProject/SanitySuperAdmin.xlsx" );
        XSSFSheet sh1 = wb.getSheetAt(FragmentNumber);
        int LastRowCount = sh1.getLastRowNum();

        for (int i = 0; i < LastRowCount; i++) {
            String TestId = sh1.getRow(i).getCell(1).getStringCellValue();

            if (TestId.equals(UseCaseID)) {
                mLogger.log(Status.INFO, "Test case ID: <br> " + sh1.getRow(i).getCell(1).getStringCellValue() + "<br>");


                mLogger.log(Status.INFO, "Preconditions:<br>  " + sh1.getRow(i).getCell(4).getStringCellValue() + "<br>");

                mLogger.log(Status.INFO, "Steps: <br> " + sh1.getRow(i).getCell(5).getStringCellValue() + "<br>");

                mLogger.log(Status.INFO, "Expected result: <br> " + sh1.getRow(i).getCell(6).getStringCellValue() + "<br>");

            }

        }

    }

}




