package com.NetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.NetBanking.utilites.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	ReadConfig read=new ReadConfig();
	public String baseurl=read.getApplication();
	public String username=read.getUsername();
	public String password= read.getpassword();
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass


	public void setUp(String br)
	{
		logger=Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("logj4.properties");

		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",read.getchromepath());
			driver=new ChromeDriver();

		} else if (br.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",read.getfirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",read.getIEpath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseurl);
	} 
	/*public static String getScreenshot()
	{
		System.out.println("Screenshot");
		TakesScreenshot ts=(TakesScreenshot) driver;

		File src=ts.getScreenshotAs(OutputType.FILE);

		String path=System.getProperty("user.dir")+"\\Screenshot\\"+System.currentTimeMillis()+".png";

		System.out.println(" path:" + path);

		File destination=new File(path);

		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}

		return path;
	}*/
	public  void takeSnapshot() throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desp= new File("filPath/screenshot_"+timestamp()+".png");
		FileUtils.copyFile(scr, desp);
	}
	public  String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public static String getScreenhot( String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


	
@AfterClass
public void tearDown()
{
	driver.quit();
}
}
