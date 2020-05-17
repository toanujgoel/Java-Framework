package JavaFramework.ExcelDataTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.SnapdealObjects.SnapdealSearchPage;
import pageObjects.SnapdealObjects.snapdealHomePage;
import pageObjects.UsefulTools.ExcelWork;
import resources.BrowserFactory;

public class ExcelDataTest extends BrowserFactory{
	
	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());

	@BeforeTest
	public void setup() throws IOException{
		driver = invokeBrowser();
		log.info("Opened Insta Login page");
		driver.get("https://www.instagram.com/");
		
	}
	
	@Test
	public void testLogin() throws IOException{
		System.out.println("Test Running");
		Map< Integer, List>excel_data = ExcelWork.readExcel("D:\\Java-Framework\\src\\main\\java\\resources\\InstaLogin.xls", 0);
		
		String username = excel_data.get(1).get(0).toString();
		String password = excel_data.get(1).get(1).toString();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
		System.out.println(driver.getCurrentUrl());
	}

	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
}
