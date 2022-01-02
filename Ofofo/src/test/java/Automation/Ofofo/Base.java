package Automation.Ofofo;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected static WebDriver driver;
	protected static Properties prop;
	
	public static WebDriver getDriver() throws Throwable
	{
		prop= new Properties();
		FileInputStream fis = new FileInputStream("D:\\Trying\\Ofofo\\src\\test\\java\\Automation\\Ofofo\\global.properties");
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
