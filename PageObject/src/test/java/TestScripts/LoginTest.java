package TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import DataDriven.TestData;
import PageModels.Login;
import resources.BaseClass;
import ReportsConfig.extentManager;


public class LoginTest extends BaseClass {


	@Test
	public void loginOrange() throws IOException {
		
		TestData.readExcel(0, "Credentials");
		extentManager.getTest().log(Status.INFO, MarkupHelper.createLabel("Test Case:loginOrange Started",ExtentColor.GREEN));
		Login lgn=new Login(driver);
		lgn.credentialsEmptyValidation();
		lgn.userNameEmptyValidation(TestData.password);
		lgn.loginApplication(TestData.username,TestData.password);

	}

}
