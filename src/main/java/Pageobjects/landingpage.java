package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class landingpage {

	public WebDriver driver;
	
	public landingpage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	By popupclose=By.cssSelector("a[class='pop_close']");
	By searchicon=By.cssSelector("[id='togglesearch']");
	By searchText=By.cssSelector("input[id='srch']");
	By submit=By.cssSelector("[id='submit_search']");

	
	public WebElement closepopup() {
		return driver.findElement(popupclose);
	}
	public void searchicon() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script="return document.getElementById(\"togglesearch\").click()";
		String text=(String) js.executeScript(script);
		System.out.println(text);
	}
	public WebElement searchText() {
		return driver.findElement(searchText);
	}
	public WebElement submitText() {
		return driver.findElement(submit);
	}
	
	
	
}

