package ScreenshotCode;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCode {
	public static void capturescreenshot(WebDriver driver,String screenshotName) {
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File Destination=new File("./Screenshots/"+screenshotName+".png");
			FileHandler.copy(source, Destination);
		}catch(Exception e) {
			System.out.println("Exception in thread"+e.getMessage());
		}
	}

}
