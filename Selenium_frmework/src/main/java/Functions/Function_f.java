package Functions;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Constants.Const_c;
import Drivers.Drivers_d;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Function_f {

	Const_c obj=new Const_c();
	public WebElement radio_ele;
	public String alert_str;
	public int col_count;
	public String iframe_add;
	
	public FirefoxDriver driver;
	
	public Function_f()
	{
		
		Drivers_d objt=new Drivers_d();
		objt.main(null);;
		driver=objt.driver;
	}
	
	
	public void check_box() throws InterruptedException 
	{
		driver.findElement(obj.check_b).click();
	}
	
	public void drop_down(String val)
	{
		WebElement ddown=driver.findElement(obj.drop_d);
		Select sec=new Select(ddown);
		sec.selectByVisibleText(val);
	}
	
	public void  radio_butto()
	{
		radio_ele=driver.findElement(obj.radio_b);
		radio_ele.click();;
	}
	
	public void multiple_select()
	{
		driver.findElement(obj.multiple_s).click();
	}
	
	public void switch_window()
	{
		String parent=driver.getWindowHandle();
		driver.findElement(obj.switch_w).click();
		Set<String> st=driver.getWindowHandles();
		int count =st.size();
		System.out.println(count);
		
		for(String child:st)
		{
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				driver.findElement(obj.home_h).click();
			}
		}
	}
	
	public void switch_tab()
	{
		String parent=driver.getWindowHandle();
		driver.findElement(obj.switch_t).click();
		Set<String> st=driver.getWindowHandles();
		int count =st.size();
		System.out.println(count);
		
		for(String child:st)
		{
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				driver.findElement(obj.home_h).click();
			}
		}
		
	}
	
	public void alert_optio() throws InterruptedException
	{
		driver.findElement(obj.alert_fill).sendKeys("Mohit");
		driver.findElement(obj.alert_o).click();
		alert_str=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	}
	
	public void table_optio()
	{
		 List<WebElement>allHeader=driver.findElements(obj.table_o);
		 col_count=allHeader.size();
		 for(WebElement e: allHeader)
		 {
			 String val=e.getText();
			 System.out.println(val);
		 }
	}
	
	public void enb_dis()
	{
		driver.findElement(obj.ele_disable).click();
		driver.findElement(By.xpath("//*[@id='enabled-example-input']")).sendKeys("mohit");
	}
	
	public void mouse_hover()
	{
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(obj.hover_b);
		act.moveToElement(ele).perform();
		
		driver.findElement(obj.hover_ele).click();
	}
	
	public void i_frame() throws InterruptedException
	{
		WebElement ele=driver.findElement(obj.iframe_i);
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();;
		driver.switchTo().frame("courses-iframe");
		Thread.sleep(2000);
		driver.findElement(obj.iframe_f).click();
		iframe_add=driver.getCurrentUrl();
	}
}
