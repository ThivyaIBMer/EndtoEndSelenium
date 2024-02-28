package ReusableMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReusableMethods {

	public void explicitWait(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));}

	public void assertEqualsCheck(WebDriver driver,String actual,String expected) {
		Assert.assertEquals(actual, expected);}

	public void goTo(WebDriver driver,String url) {
		driver.get(url);}

	public void click(WebElement element) {
		element.click();}

	public void sendText(WebElement element,String value) {
		element.sendKeys(value);
	}
	public void sendText_Using_JavaScriptExecutor(WebDriver driver,WebElement ele,String text) {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+text+"';", ele);
	}
	public void dropDownSelectByIndex(WebElement dropdown,int value) {
		Select dropdown_values=new Select(dropdown); 
		dropdown_values.selectByIndex(value);}

	public void dropDownSelectByValue(WebElement dropdown,String value) {
		Select dropdown_values=new Select(dropdown); 
		dropdown_values.selectByValue(value);}

	public void dropDownSelectByVisibleText(WebElement dropdown,String value) {
		Select dropdown_values=new Select(dropdown); 
		dropdown_values.selectByVisibleText(value);}

	public void dynamicDropDown(WebDriver driver,By ele,String expectedValue) {
		List<WebElement> dropdownList=driver.findElements(ele);
		for(WebElement webEle:dropdownList)
		{ 
			if(webEle.getText().equals(expectedValue)) {

				webEle.click();
				break; 
			} 
		}
	}

}
