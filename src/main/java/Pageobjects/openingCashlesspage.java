package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class openingCashlesspage {
public WebDriver driver;
	
	public openingCashlesspage(WebDriver driver) {
		
		this.driver=driver;
	}
	By services=By.cssSelector("a[title='Customer Services']");
	public void openGarage() {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(services)).build().perform();
		driver.findElement(By.linkText("Cashless Garages")).click();
	}
}
