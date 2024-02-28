package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import ReportsConfig.extentManager;
import ReusableMethods.ReusableMethods;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ReusableMethods {
	public static WebDriver driver;
	static  Logger log=Logger.getLogger(BaseClass.class);

	@BeforeSuite
	public void setReport() {
		extentManager.setExtent();
	}
	@AfterSuite
	public void WriteReport() {
		extentManager.endReport();
	}

	@BeforeMethod
	public void driverInitialization() throws IOException {
		log.info("Get the path of properties file");
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\app.properties";
		FileInputStream fis=new FileInputStream(path);

		log.info("Load the path in properties file");
		Properties prop=new Properties();
		prop.load(fis);

		log.info("Get the browser from properties file");
	
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		/*
		 * if(System.getProperty("browser")!=null) { System.getProperty("browser"); }
		 * else { prop.getProperty("browser"); }
		 */
		if(browserName.equalsIgnoreCase("Chrome")) {
			log.info("Launch the chrome browser");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			log.info("Launch the FireFox browser");
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			log.info("Launch the edge browser");
			//WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		log.info("Navigate to the url");
		goTo(driver,prop.getProperty("URL"));
		log.info("Maximize the browser");
		driver.manage().window().maximize(); 
		log.info("Implemented implicit wait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void driverClose() {
		log.info("Close the browser");
		driver.quit();
	}

	public static String screenShot(WebDriver driver,String fileName) throws IOException {
		String dateTime=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\ScreenShots\\"+fileName+"_"+dateTime+".png";
		FileUtils.copyFile(src, new File(destination));
		return destination;
	}

































}
