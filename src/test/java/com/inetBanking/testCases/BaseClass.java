package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	public static WebDriver driver;
	
	  public String url=readConfig.getApplicationUrl();
	  public String userName=readConfig.getUsername(); 
	  public String password=readConfig.getPassword();
	 
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String brn)
	{
		
		if(brn.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					readConfig.getChromePath());
			driver=new ChromeDriver();	
		}
		else if(brn.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					readConfig.getChromePath());
			 driver = new FirefoxDriver();
		}
		else if (brn.equals("ie")){
			System.setProperty("webdriver.edge.driver", 
					readConfig.getEdgePath());
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url); 
		
		
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public void captureScreen(WebDriver driver,String testName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File Target=new File(System.getProperty("user.dir"+"/Screenshots/"+testName+".png"));
		FileUtils.copyFile(src, Target);
		System.out.println("ScreenShot Tsken...!");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
