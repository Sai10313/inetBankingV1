package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	

	@Override
	public void onTestSuccess(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File file=new File(screenShotPath);
		if(file.exists()) {
			try {
				logger.fail("Screenshot below is :"+logger.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onStart(ITestContext testContext) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repoName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repoName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent =new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserName", "Sai Kumar");
		
		htmlReporter.config().setDocumentTitle("INetBanking Test Project");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}


}
