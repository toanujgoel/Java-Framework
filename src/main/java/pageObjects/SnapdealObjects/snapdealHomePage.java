package pageObjects.SnapdealObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class snapdealHomePage{
	
	WebDriver driver;
	
	public snapdealHomePage(WebDriver driver){
		this.driver=driver;
	}

	By searchBar = By.id("inputValEnter");
	By searchButton = By.className("searchTextSpan");
	
	public WebElement getSearchField(){
		return driver.findElement(searchBar);
		}
	
	public WebElement getSearchButton(){
		return driver.findElement(searchButton);
	}
			
}
