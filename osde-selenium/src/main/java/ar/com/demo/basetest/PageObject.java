package ar.com.demo.basetest;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {

	private WebDriver driver;
	
	public PageObject(WebDriver driver) {
		this.driver = driver;
	}
 
	public WebDriver getDriver() {
		return driver;
	}
	
	public void esperar(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}