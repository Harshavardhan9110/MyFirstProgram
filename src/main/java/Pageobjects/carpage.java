package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class carpage {
	
public WebDriver driver;

public carpage(WebDriver driver) {
	this.driver=driver;
}

public void check() {
	
	Assert.assertTrue(driver.getPageSource().contains("car"),"text is present");  
     System.out.println("car is visible");
}
}
