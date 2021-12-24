package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class validatingCorporateMission {

	public WebDriver driver;
	
	public validatingCorporateMission(WebDriver driver) {
		
		this.driver=driver;
	}
	By Aboutus=By.cssSelector("li[class='dropdown']");
	public void Aboutus() {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(Aboutus)).build().perform();
		driver.findElement(By.linkText("Corporate Mission")).click();
	}
	public void visible() {
		
		Assert.assertTrue(driver.getPageSource().contains("Corporate Mission"),"text is present");  
	     System.out.println("corporate Mission is visible");
	}
	

}
