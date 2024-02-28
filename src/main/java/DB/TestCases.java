//package DB;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import com.ExtentManager.extentManager;
//import com.aventstack.extentreports.Status;
//
//import Driver.MedplusDriver;
//import Excel.TestData;
//import Pages.ICD;
//import Resources.BaseClass;
//
//
/////TEstCases to refer on how tocall DB function
//public class TestCases 
//{
//	@Test
//	@Parameters({ "UserName", "Password" })
//	public void loginPageTest(String UserName, String Password) throws Exception {
//
//		
//		MedplusDriver.getExcel().readExcel(2, "ICD");
//		
//		extentManager.test.log(Status.INFO, "[Start the test by logging in]");
//		Login(UserName, Password);
//		extentManager.test.log(Status.PASS, "[Successfully logging in]");
//
//		extentManager.test.log(Status.INFO, "[Click the Manage button]");
//		MedplusDriver.getICD().Manage.click();
//		extentManager.test.log(Status.PASS, "[Clicked the Manage button]");
//
//		extentManager.test.log(Status.INFO, "[Click the ICD button]");
//		MedplusDriver.getICD().ICD.click();
//		extentManager.test.log(Status.PASS, "[Clicked the ICD button]");
//
//		extentManager.test.log(Status.INFO, "[Click the ICD Add button]");
//		MedplusDriver.getICD().Add.click();
//		extentManager.test.log(Status.PASS, "[Clicked the ICD Add button]");
//
//		Thread.sleep(3000);
//		extentManager.test.log(Status.INFO, "[Send the icd number]");
//		wait.until(ExpectedConditions.presenceOfElementLocated(ICD.wait_ICDnum())).sendKeys(TestData.ICD_numbers);
//		extentManager.test.log(Status.PASS, "[Sent the icd number]");
//
//		Thread.sleep(3000);
//		extentManager.test.log(Status.INFO, "[Choose the icd type]");
//		MedplusDriver.getICD().ICD_codeType.click();
//		Select icd_dropdown = new Select(MedplusDriver.getICD().ICD_codeType);
//		icd_dropdown.selectByValue(TestData.ICD_code);
//		extentManager.test.log(Status.PASS, "[ICD Type is chosen]");
//
//		extentManager.test.log(Status.INFO, "[Send the icd name]");
//		MedplusDriver.getICD().ICD_codeName.sendKeys(TestData.ICD_name);
//		extentManager.test.log(Status.PASS, "[Sent the icd name]");
//
//		Thread.sleep(3000);
//		
//		extentManager.test.log(Status.INFO, "[Click the submit button]");
//		MedplusDriver.getICD().ICD_submit.click();
//		extentManager.test.log(Status.PASS, "[Submit button clicked]");
//
//		extentManager.test.log(Status.INFO, "[Click the submit button]");
//		String successMsg = wait.until(ExpectedConditions.presenceOfElementLocated(ICD.wait_successMsg())).getText();
//		SoftAssert a = new SoftAssert();
//
//		a.assertEquals(successMsg, "ICD Code added successfully");
//		extentManager.test.log(Status.PASS, "[Submit button clicked]");
//		a.assertAll();
//		
//		/*These three lines are needed for calling db"*/
//		
//		String[] UIvalues= {TestData.ICD_numbers,TestData.ICD_code,TestData.ICD_name};
//		String query= String.format("SELECT * from mp_icd_codes where icd_code_number= '%1$s'",TestData.ICD_numbers);
//		
//		MedplusDriver.getDbConnection().DB("ICD",query, UIvalues);
//
//	}
//
//	
//
//
//}
