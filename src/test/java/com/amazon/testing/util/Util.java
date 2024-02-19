package com.amazon.testing.util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * It holds the functions created by the user and implement's them in project
 * 
 */
public class Util {	
	WebDriver driver = null;	
	public Util(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * This function is used to input the data to the required element by using  it's xPath
	 */
	public void sendKeys(String xpath, String sendkeys) {
		driver.findElement(By.xpath(xpath)).sendKeys(sendkeys);
	}
	/*
	 * This function is used to operate the click action through the xPAth
	 */
	public void click(String click) {
		driver.findElement(By.xpath(click)).click();
	}
	/*
	 * 	  This function is used to operate the double click action required element by using  it's xPath
	 */
	public void cAndc(String click1, String click2) {
		click(click1);
		click(click2);
	}
	/*
	 * 	 This function is used to wait for the element until it appears through element  xPath
	 */
	public void waiting(String xPath) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
	/*
	 * 	 	 This function is used to wait and input the data to the required element by using  it's xPath 
	 */
	public void waitAndSendKey (String xPath ,String sendkeys) {
		waiting(xPath);
		sendKeys(xPath,sendkeys);
	}
	
	/*
	 *  	 This function is used to wait for the element visibility and click on it by using it's xPath 
	 */
	public void waitAndClick(String xPath) {
		waiting(xPath);
		click(xPath);
	}
	/*
	 *  This function is used to move the cursor to the required element by using  it's xPath 
	 */
	public void scrollBy(String xPath) {
		WebElement ele = driver.findElement(By.xpath(xPath));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	/*
	 *   This function is used to right click on the touch pad  by using  it's xPath 
	 */
	public void rightClick(String xPath) {
		WebElement ele = driver.findElement(By.xpath(xPath));
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
	}
	/*
	 *   This function is used to scroll the window until the element appears  by using  it's xPath 
	 */
	public void scrollBYEle(String xPath) {
		WebElement ele = driver.findElement(By.xpath(xPath));
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",ele);
	}
	/*
	 * 	  This function is used to operate the  click action required element by using  it's ID
	 */
	public void clickById(String id) {
		driver.findElement(By.id(id)).click();
	}	
	public void SendkeyEnter(String xPath,Keys Enter) {
		waiting(xPath);
		driver.findElement(By.xpath(xPath)).sendKeys(Keys.ENTER);
	}
}


