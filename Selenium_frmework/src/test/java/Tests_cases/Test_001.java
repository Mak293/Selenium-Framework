package Tests_cases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Constants.Const_c;
import Functions.Function_f;
import JDBC_connector.JDBC_c;
import Rest_asssured.Rest_assured_res;
import Utility.Screen_shorts;
import io.restassured.response.Response;

import Reports.Reports_r;
import Rest_asssured.Rest_assured_res;
import io.restassured.response.Response;

@Listeners(Listeners_L.class)
public class Test_001 {
	
	Function_f obj=new Function_f();
	Const_c cst=new Const_c();
	
	String check_url="https://courses.letskodeit.com/practice";
	String Windo=obj.driver.getWindowHandle();
	JDBC_c ob=new JDBC_c();
	
	Rest_assured_res res=new Rest_assured_res();
	
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@Test(priority=1)
	public void drop_assert()
	{
		logger=report.startTest("Drop Down");
		obj.drop_down("BMW");
		Select sec=new Select(obj.driver.findElement(cst.drop_d));
		String opt=sec.getFirstSelectedOption().getText();
		AssertJUnit.assertEquals("BMW",opt);
		logger.log(LogStatus.PASS, "Test CAse Passed");
		
		logger.log(LogStatus.INFO, "Check the drop down operation");  
	}
	
	@Test(priority=2)
	public void radio_asser()
	{
		logger=report.startTest("Radio Buuton");
		obj.radio_butto();
		AssertJUnit.assertEquals(cst.radio_b,By.xpath("//*[@id='hondaradio']"));
		logger.log(LogStatus.PASS, "Test CAse Passed");

		logger.log(LogStatus.INFO, "Check the Radio button operation");
	}
	
	@Test(priority=3)
	public void check_assert() throws InterruptedException
	{
		logger=report.startTest("Check Box");
		obj.check_box();
		String url=obj.driver.getCurrentUrl();
		AssertJUnit.assertEquals(check_url, url);
		logger.log(LogStatus.PASS, "Test CAse Passed");

		logger.log(LogStatus.INFO, "Check the chackbox operation");
	}
	
	
	@Test
	public void alert_ssert() throws InterruptedException
	{
		logger=report.startTest("Alert Window");
		obj.alert_optio();
		AssertJUnit.assertEquals(obj.alert_str,"Hello Mohit, share this practice page and share your knowledge");
		logger.log(LogStatus.PASS, "Test CAse Passed");
		

		logger.log(LogStatus.INFO, "Check the alert window operation");
	}
	
	@Test
	public void table_assert()
	{
		logger=report.startTest("Table");
		obj.table_optio();
		AssertJUnit.assertEquals(3,obj.col_count);
		logger.log(LogStatus.PASS, "Test CAse Passed");

		logger.log(LogStatus.INFO, "Check the table data");
	}
	
	@Test
	public void mouser_assert()
	{
		logger=report.startTest("Mouse Movement");
		obj.mouse_hover();
		AssertJUnit.assertTrue(obj.driver.findElement(cst.hover_ele).isDisplayed());
		logger.log(LogStatus.PASS, "Test CAse Passed");

		logger.log(LogStatus.INFO, "Check the mouse hover operation");
	}
	
	@Test(priority=8)
	public void iFrame_assert() throws InterruptedException
	{
		logger=report.startTest("IFrame");
		obj.driver.switchTo().window(Windo);
		
		AssertJUnit.assertEquals(obj.iframe_add,null);
		logger.log(LogStatus.PASS, "Test CAse Passed");

		logger.log(LogStatus.INFO, "Check the iFrame operation");
	}
	
	@Test
	public void test() throws ClassNotFoundException, SQLException
	{
		logger=report.startTest("SQL Connection");
		ob.main(null);
		Statement st=ob.con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from user;");
		
		while(rs.next())
		{
			System.out.println(rs.getString("f_name"));
		}
		logger.log(LogStatus.PASS, "Test CAse Passed");

		logger.log(LogStatus.INFO, "Check the data base");
		
	}
	
	@Test
	public void test_100()
	{
		Response re=res.get_cmd(check_url);
		System.out.println(re.statusCode());

		logger.log(LogStatus.INFO, "Check the status code");
	}
	
	@Test
	public void test_200()
	{
		String input="delete";
		if(input.equals("get")) 
		{
			Response re=res.get_cmd(check_url);
			System.out.println(re.statusCode());
		}
		
		else
		{
			Response re=res.delete_cmd(check_url);
			System.out.println(re.statusCode());
		}

		logger.log(LogStatus.INFO, "Get & Delete");
	}
	
	@BeforeClass
	public void setExtent()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"/test-output/Z_1.html",true);
		
	}
	
	@AfterClass
	public void endReport()
	{
		
		report.flush();
		report.close();
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getThrowable());
			
			String screenshotPath = Screen_shorts.getScreenshot(obj.driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getThrowable());
		}
		report.endTest(logger);				
	}
}