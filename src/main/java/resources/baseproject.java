package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class baseproject {
	public static WebDriver driver;
	public 	Properties prop;
	
	public WebDriver initialzeDriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Harshavardhan\\eclipse-workspace\\MilestoneAssesment3\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshavardhan\\OneDrive\\Documents\\chromeDriver.exe");
			 driver=new ChromeDriver();
		  
		}
		else if(browserName.equals("firefox")) {
		
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harshavardhan\\OneDrive\\Documents\\geckodriver.exe");		
			 driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
		
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Harshavardhan\\OneDrive\\Documents\\IEDriverServer.exe");		
			 driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	public void getScreenshot(String result) throws IOException {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File Destination=new File("./Screenshots/"+result+".png");
		FileHandler.copy(source, Destination);
	}
	
}
