package ar.com.demo.basetest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	protected WebDriver driverTest;
	private ChromeOptions options;
	/*@Before
	public void setUp() throws InterruptedException {
		System.out.print("Iniciando");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\rmamani\\eclipse-workspace\\osde-selenium\\drivers\\IEDriverServer.exe");
		//driver = new ChromeDriver();
		driver = new InternetExplorerDriver();
		Thread.sleep(1000);
	}*/
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"drivers/chromedriver.exe");
		
		String extFilePath = "C:\\Users\\rmamani\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ocgghcnnjekfpbmafindjmijdpopafoe\\0.7.0_0.crx";
		//ChromeOptions 
		options = new ChromeOptions();
		options.addExtensions(new File(extFilePath));
		
		driverTest = new ChromeDriver(options);
		driverTest.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void close() {
		System.out.print("Terminando");
		//driver.quit();
	}
	
}
