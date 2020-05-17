package JavaFramework.SnapdealTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.SnapdealObjects.SnapdealSearchPage;
import pageObjects.SnapdealObjects.snapdealHomePage;
import resources.BrowserFactory;

public class snapdealScenarioTest extends BrowserFactory{
	
	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());

	@BeforeTest
	public void setup() throws IOException{
		driver = invokeBrowser();
		driver.get("https://www.snapdeal.com");
		log.info("Opened homepage");
	}
	
	@Test
	public void testPriceSlider(){
		System.out.println("Test Running");
		snapdealHomePage home = new snapdealHomePage(driver);
		home.getSearchField().sendKeys(prop.getProperty("snapdealSearchProduct"));
		log.debug("Searched the product");
		home.getSearchButton().click();
		
		SnapdealSearchPage searchPage = new SnapdealSearchPage(driver);
		Actions action = new Actions(driver);
		action.dragAndDropBy(searchPage.getLeftSlider(), 0, 199).build().perform();
		action.dragAndDropBy(searchPage.getRightSlider(), 0, 225).build().perform();
		System.out.println("Left is "+searchPage.getFromText().getText());
		System.out.println("Right is "+searchPage.getToText().getText());
	}

	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
}
