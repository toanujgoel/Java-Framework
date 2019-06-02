package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {


	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());
	public static WebDriver driver;
	public Properties prop;

	public WebDriver invokeBrowser() throws IOException{

		prop = new Properties();

		String sourcePath = System.getProperty("user.dir");
		FileInputStream dataFile = new FileInputStream(sourcePath+"\\src\\main\\java\\resources\\data.properties");

		prop.load(dataFile);

		String browserName = prop.getProperty("browser");
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWaitInSeconds"));

		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", sourcePath+"\\webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")){
			System.setProperty("webdriver.chrome.driver", sourcePath+"\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("internet explorer")){
			System.setProperty("webdriver.chrome.driver", sourcePath+"\\webdrivers\\iedriver.exe");
			driver = new InternetExplorerDriver();
			}
		else
			System.out.println("Incorrect browser name provided in the data file");

		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public void getScreenshot(String result){
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.moveFile(src, new File("C:\\Users\\Anuj Goel\\Desktop\\"+result+"\\Screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
