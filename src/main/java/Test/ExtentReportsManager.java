package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsManager {
   // public static ExtentHtmlReporter htmlReporte;
    public static ExtentReports report;
    public static  ExtentTest logger;
    public static   WebDriver driver;

    public ExtentReportsManager( WebDriver driver,ExtentTest logger) {
        ExtentReportsManager.driver= driver;
        ExtentReportsManager.logger= ExtentTestManager.getTest();
    }


    public ExtentReportsManager(){

    }


    public  static ExtentReports getReportInstances(){


            ExtentHtmlReporter   htmlReporte=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Result/ExtentResult.html");
            report= new ExtentReports();
            report.attachReporter(htmlReporte);


            report.setSystemInfo("OS", "MAC");
            report.setSystemInfo("Environnement", "UAT");
            report.setSystemInfo("Browser", "Firefox");
            htmlReporte.config().setDocumentTitle("Automation Results");
            htmlReporte.config().setReportName("TestReport");
            htmlReporte.config().setTimeStampFormat("MM dd, yyy HH:mm:ss");


        return report;
    }



    public static void getscreenshot(WebDriver driver, ExtentTest logger)throws IOException{


        SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Date date=new Date();
        String fileName=sdf.format(date);
       // TakesScreenshot takeScreenshot=((TakesScreenshot) driver);
        File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" + fileName + ".pnj";
        File desfile=new File (destination);
            FileUtils.copyFile(screenshot, desfile);
        logger.addScreenCaptureFromPath(destination);




    }




}
