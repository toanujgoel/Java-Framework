package pageObjects.SnapdealObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SnapdealSearchPage {
	
	WebDriver driver;
	
	public SnapdealSearchPage(WebDriver driver){
		this.driver=driver;
	}

	By LPriceSlider = By.xpath("//a[contains(@class, 'price-slider-scroll left-handle')]");
	By RPriceSlider = By.xpath("//a[contains(@class, 'price-slider-scroll right-handle')]");
	By FromPrice = By.className("from-price-text");
	By ToPrice = By.className("to-price-text");
	
	public WebElement getLeftSlider(){
		return driver.findElement(LPriceSlider);
	}
	
	public WebElement getRightSlider(){
		return driver.findElement(RPriceSlider);
	}
	
	public WebElement getToText(){
		return driver.findElement(ToPrice);
	}
	
	public WebElement getFromText(){
		return driver.findElement(FromPrice);
	}
	
	
}
