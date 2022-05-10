package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass {
    WebDriver driver;

    LoginScreen loging;
    CreateAdmin account;
    ConnectAdmin connectAdmin;
    CreateCompany creatCompany;
    ExtentReportsManager extentReportsManager;
   ExtentReports report;
    ExtentTest logger;
    CreateGroupe creategroupe;
    CreatUser creatuser;
    Admin_CreateUSer Admin_CreatUSer;
    CreateResellers createresellers;
    Admin_UpdateUser Admin_UpdateUSer;
    Admin_CreatGroup Admin_Creatgp;
    Settings settings;
    CreateDepartment createDepartment;
    MyBusniess myBusniess;

    @BeforeTest
    public  void startTest()   {
    extentReportsManager = new ExtentReportsManager(driver,logger);
     report  =ExtentReportsManager.getReportInstances();

    }

@AfterTest
        public void End (){
    report.flush();}


@Test
public void test1() throws IOException{
    logger  = report.createTest("TestOne","");
    System.setProperty("webdriver.gecko.driver", "/Users/macbookpro/IdeaProjects/SeleniumProject/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rh8-superadmin-preprod.teamontherun.com/#/login");
       logger.log(Status.PASS, "Browser opened with sucess ");
      ExtentReportsManager.getscreenshot( driver,logger);

    }

    @Test(priority = 1)

    void Login_STC1() throws InterruptedException, IOException{
        logger=report.createTest("Login_STC1","Check disponiblite of element ");
        loging=new LoginScreen(driver, logger);
       // loging.GetUseCaseDescription("Login_STC1",1, logger);
        loging.checkelement();

    }


    @Test(priority = 2)
    void Login_STC2() throws InterruptedException, IOException{
        logger=report.createTest("Login_STC2","Check error ");
        STW.GetUseCaseDescription("Login_STC2",1, logger);

        loging=new LoginScreen(driver, logger);
        loging.connect("1sw-Streamwide", "admin@streamwide.com");

    }

/*
    @Test(priority = 3)
    void Login_STC3() throws InterruptedException, IOException{
        logger=report.createTest("Login_STC2","login with sucess  ");
        loging=new LoginScreen(driver, logger);
        loging.connect("1sw-Streamwide", "admin@streamwide.com");

    }
    @Test(priority = 4)
    void Account_STC1() throws InterruptedException, IOException{
        logger=report.createTest("Account_STC1","Add Acount existant ");
        account=new CreateAdmin(driver, logger);
        account.creatAdmin("","","");

    }

    @Test(priority = 5)
    void Account_STC2() throws InterruptedException, IOException{
        logger=report.createTest("Account_STC2","Add Account ");
        account=new CreateAdmin(driver, logger);
        account.creatAdmin("","","");
    }

    @Test(priority = 6)
    void Account_STC3() throws InterruptedException, IOException{
        logger=report.createTest("Account_STC3","Search  Account ");
        account=new CreateAdmin(driver, logger);
        account.creatAdmin("","","");
    }
    @Test(priority = 7)
    void Account_STC4() throws InterruptedException, IOException{
        logger=report.createTest("Account_STC4","Edit   Account ");
        account=new CreateAdmin(driver, logger);
        account.creatAdmin("","","");
    }
    @Test(priority = 8)
    void Account_STC5() throws InterruptedException, IOException{
        logger=report.createTest("Account_STC5","Delet  Account ");
        account=new CreateAdmin(driver, logger);
        account.creatAdmin("","","");
    }







    //  creatadmin=new CreateAdmin(driver,logger);
        
        
      //  creatadmin.creatAdmin();


      //  creatCompany=new CreateCompany(driver,logger);
      // creatCompany.Search("34");
     //  creatCompany.checkelement();
      //  creatCompany.AddCompany("com","Non","KKK","ZZZ","khou@gmail.Com",505,198);
      //  creategroupe=new CreateGroupe(driver,logger);
        //creategroupe.CreatGroupe();
     //   creatuser=new CreatUser(driver,logger);
       // creatuser.CreateUser("+216","93 949 593","khouloud","Zaiiem","TnTestingTeam");
       //   creatuser.updateuser();


      //  creatuser.deleteuser();

      //  connectAdmin=new ConnectAdmin(driver,logger);
       //connectAdmin.Admin();

      //  Admin_CreatUSer =new Admin_CreateUSer(driver, logger);
     //  Admin_CreatUSer.USerWithBarring("khou","zaiemmmm","99118822");
     //   Admin_UpdateUSer=new Admin_UpdateUser(driver,logger);
        //Admin_UpdateUSer.SerchContact("khouloud WCH");
     //   Admin_Creatgp=new Admin_CreatGroup(driver,logger);

     //  Admin_Creatgp.Edit("TestKhouloud","Android 5");
      //  settings=new Settings(driver,logger);

    // settings.AddEmergencyMSG("test","khouloud WCH","khouloud Barring","khouloud WCH","khouloud Barring");


       // createresellers=new CreateResellers(driver,logger);
     /*  createresellers.create("khouloud zaiem","zaiemk@streamwide.com","tunis","7070","Tunisia",
                "khouloudAdmin","ZAiemAdmin","21696112296","zzaiem@streamwide.com",
                "khouloudAdmin","ZAiemAdmin","21696112296","zzzaiem@streamwide.com",
                "khouloudAdmin","ZAiemAdmin","21696112296","zzzzaiem@streamwide.com",
                "khouloudAdmin","ZAiemAdmin","21696112296","zzzzzaiem@streamwide.com");*/


 //  createresellers.Search("khouloud zaiem");
   //  createresellers.checkelement();
    //createresellers.deletResellers();
    //    createDepartment=new CreateDepartment(driver,logger);
       // createDepartment.serachDepartment("comm","khouloud");
      //  createDepartment.deletResellers();


      //  myBusniess=new MyBusniess(driver,logger,"STC busniss", );
      //  myBusniess.createProcess("khouloud");
    }
