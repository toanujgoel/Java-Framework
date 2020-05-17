package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
		System.out.println("Inside Screenshot");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String target_dir = System.getProperty("user.dir")+"\\failureScreenshots\\"+result+"\\Screenshot.png";
		try {
			FileUtils.moveFile(src, new File(target_dir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR Screnshot"+ e);
		}
		log.info("Test Failed. Refer screenshot : "+target_dir);
	} 
}
