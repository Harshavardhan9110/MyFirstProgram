package root;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import Pageobjects.carpage;
import Pageobjects.landingpage;
import Pageobjects.openingCashlesspage;
import Pageobjects.validatingCorporateMission;
import ScreenshotCode.ScreenshotCode;
import junit.framework.Assert;
import resources.baseproject;

public class Homepage extends baseproject {
	  private static Logger log=LogManager.getLogger(Homepage.class.getName());
		 ExtentReports   extent;
		  ExtentHtmlReporter report;
		  
		  ScreenshotCode sc=new ScreenshotCode();
	@BeforeTest
	public void initialize() throws IOException {
		driver=initialzeDriver();
		driver.get(prop.getProperty("url"));
		log.info("url loaded");
		ExtentHtmlReporter report=new ExtentHtmlReporter("./reports/result.html");
	     extent=new ExtentReports();
	    extent.attachReporter(report);
	}
	@Test
	public void testcase1() {
		ExtentTest logger=extent.createTest("test1 success");
		landingpage land=new landingpage(driver);
		logger.log(Status.PASS, "successfully logedin");
		land.closepopup().click();
		land.searchicon();
		log.info("car is searched");
		logger.log(Status.PASS, "successfully searched");
		land.searchText().sendKeys("car");
		land.submitText().click();
	carpage c=new carpage(driver);
	    c.check();
	    sc.capturescreenshot(driver, "success test 1");
	    extent.flush();
	}
     @Test
     public void testcase2() {
    	 ExtentTest logger=extent.createTest("test2 success");
    	 validatingCorporateMission v=new validatingCorporateMission(driver);
    	 logger.log(Status.PASS, "successfully load");
    	 v.Aboutus();
    	 log.info("successfully mouse hovered");
    	 v.visible();
    	 logger.log(Status.PASS, "element is visible");
    	 sc.capturescreenshot(driver, "success test 2");
 		extent.flush();
     }
     @Test 
     public void testcase3() {
    	 ExtentTest logger=extent.createTest("test3 success");
    	 openingCashlesspage op=new openingCashlesspage(driver);
    	 op.openGarage();
    	 log.info("successfully garage link is opened");
    	 logger.log(Status.PASS, "garage lik is opened");
    	 sc.capturescreenshot(driver, "success test 3");
 		extent.flush();
     }
     @AfterTest
     public void teardown() {
    	 driver.quit();
     }
     
}
