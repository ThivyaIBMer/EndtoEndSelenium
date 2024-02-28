package PageModels;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import ReusableMethods.ReusableMethods;
import ReportsConfig.extentManager;

public class Login extends ReusableMethods {

	WebDriver driver;
	static  Logger log=Logger.getLogger(Login.class);

	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[placeholder='Username']")
	WebElement userName;

	@FindBy(css="input[placeholder='Password']")
	WebElement userPassword;

	@FindBy(css="button[type='submit']")
	WebElement Submit;

	@FindBy(xpath="//label[text()='Username']/../../child::span")
	WebElement UserNameErrorMsg;

	@FindBy(xpath="//label[text()='Password']/../../child::span")
	WebElement PasswordErrorMsg;

	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement DashboardAfterLogin;



	public void credentialsEmptyValidation() {
		extentManager.getTest().log(Status.INFO,extentManager.messageLog("Validating without username and password"));
		extentManager.getTest().log(Status.INFO, "Click submit button");
		click(Submit);
		extentManager.getTest().log(Status.INFO, "Verify userName error message");
		assertEqualsCheck(driver,UserNameErrorMsg.getText(),"Required");
		extentManager.getTest().log(Status.INFO, "Verify password error message");
		assertEqualsCheck(driver,PasswordErrorMsg.getText(),"Required");
		extentManager.getTest().log(Status.PASS,extentManager.messageLog("Validating without username and password"));
	}
	public void userNameEmptyValidation(String password) {
		extentManager.getTest().log(Status.INFO,extentManager.messageLog("Validating without username"));
		extentManager.getTest().log(Status.INFO, "Send password");
		//userPassword.sendKeys(password);
		sendText(userPassword,password);
		extentManager.getTest().log(Status.INFO, "click submit button");
		click(Submit);
		extentManager.getTest().log(Status.INFO, "Verify error message");
		assertEqualsCheck(driver,UserNameErrorMsg.getText(),"Required");
		extentManager.getTest().log(Status.PASS,extentManager.messageLog("Validating without username"));
	}
	public void loginApplication(String username,String password) {
		extentManager.getTest().log(Status.INFO,extentManager.messageLog("Login using appropriate username and password"));
		log.info("*****************Calling loginApplication Method****************************");
		log.info("Enter username");
		extentManager.getTest().log(Status.INFO, "Enter username");
		sendText(userName,username);
		log.info("Entered username");
		extentManager.getTest().log(Status.PASS, "Entered username");
		log.info("Clear the existing password");
		extentManager.getTest().log(Status.INFO, "Clear the existing password");
		userPassword.sendKeys(Keys.CONTROL+"A");
		userPassword.sendKeys(Keys.DELETE);
		log.info("cleared password");
		extentManager.getTest().log(Status.PASS, "Cleared password");
		log.info("Enter the password");
		extentManager.getTest().log(Status.INFO, "Enter password");
		sendText(userPassword,password);
		extentManager.getTest().log(Status.PASS, "Entered password");
		log.info("Entered password");
		extentManager.getTest().log(Status.INFO, "click the submit button");
		log.info("Click submit button");
		click(Submit);
		log.info("Submit button clicked");
		extentManager.getTest().log(Status.PASS, "Clicked Submit button");
		log.info("Verify the landing page text");
		extentManager.getTest().log(Status.INFO, "Verify the landing page");
		assertEqualsCheck(driver,DashboardAfterLogin.getText(), "Dashboard");
		log.info("Logged in successfully");
		log.info("*****************loginApplication Method Ended****************************");
		extentManager.getTest().log(Status.PASS,extentManager.messageLog("Logged in Successfully"));

	}
}
