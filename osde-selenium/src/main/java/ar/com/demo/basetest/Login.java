package ar.com.demo.basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends PageObject{

	public Login(WebDriver driver) {
		super(driver);
	}

	private WebElement user;
	private WebElement password;
	private WebElement submitButton;
	
	
	public Login loginToApplication(String userData, String passwordData) {
		String guid = this.getDriver().getWindowHandle();
		System.out.println("Login: "+guid);
		
		user = this.getDriver().findElement(By.id("usuario"));
		user.sendKeys(userData);
		
		password = this.getDriver().findElement(By.id("password"));
		password.sendKeys(passwordData);
		
		submitButton = this.getDriver().findElement(By.xpath("//*[@id=\"frmLogin\"]/table/tbody/tr[4]/td[4]/input"));
		submitButton.click();
		
		this.esperar(1500);
		
		return this;
	}
}
