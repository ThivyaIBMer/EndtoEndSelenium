package ReportsConfig;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentManager {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static void setExtent() {
    	Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");  
		String strDate = dateFormat.format(date); 

		String path=System.getProperty("user.dir")+"\\reports\\TestResults_"+strDate+".html";
        
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results-OrangeHRM");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("TesterName", "Thivya");
    }

    public static void endReport() {
        extent.flush();
    }

    public static ExtentTest getTest() {
        return testThreadLocal.get();
    }

    public static void setTest(ExtentTest test) {
        testThreadLocal.set(test);
    }
   public static Markup messageLog(String message) {
	   return MarkupHelper.createLabel(message,ExtentColor.CYAN);
   }
}
