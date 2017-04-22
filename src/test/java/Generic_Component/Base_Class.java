package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base_Class {
	
	public WebDriver driver;
	public static Logger log=Logger.getLogger(Base_Class.class);
	public ExtentReports  extentreport;
	public ExtentTest extenttest;
	
	//@Parameters({"browser"})
	@BeforeMethod(groups={"smoke","regression"})
	public void Initbrowser()
	{
		//browser_type=btype;
//		if(btype.equalsIgnoreCase("firefox")){
//			driver = new FirefoxDriver();
//		}else if(btype.equalsIgnoreCase("chrome")){
//			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Testing\\chromedriv\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}else if(btype.equalsIgnoreCase("ie")){
//			System.setProperty("webdriver.ie.driver", "D:\\Selenium_Testing\\IEDriver\\IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
//		}
		driver= new FirefoxDriver();
		
		driver.get("http://books.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		
	}
	
	public String Capture_Screenshot(String TC_ID,String Order_Set) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String str= df.format(date)+".png";
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\Jan_Framework\\Screenshot\\" +TC_ID+"-"+Order_Set+"-"+str));
		
		String path="D:\\Jan_Framework\\Screenshot\\" +TC_ID+"-"+Order_Set+"-"+str;
		return path;
		
	}
	
	@BeforeSuite(groups={"smoke","regression"})
	public void Report_extent()
	{
		
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String Report= df.format(date);
		extentreport = new ExtentReports("D:\\Jan_Framework\\Report\\"+"Bookrediff"+"-"+Report+".html",false);
		
		
	}
	
	
	@AfterMethod(groups={"smoke","regression"})
	public void teardown()
	{
		driver.quit();
		
		extentreport.endTest(extenttest);
		extentreport.flush();
	}

}
