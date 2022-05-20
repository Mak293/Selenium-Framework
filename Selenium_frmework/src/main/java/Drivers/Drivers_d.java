package Drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers_d {

public static FirefoxDriver driver;
	
	public static void main(String []args)
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://courses.letskodeit.com/practice");
	}
	


}
