package Reports;


import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports_r {

	public ExtentReports report;
	public ExtentTest logger;
	
	public void setExtent()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"/test-output/Z_1.html",true);
		
	}
	
	public void endReport()
	{
		
		report.flush();
		report.close();
	}
	
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getThrowable());
		}
		report.endTest(logger);			
	}
}
