package ar.com.demo.basetest;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testeador extends BaseTest{

	@Test
	public void testearEntorno() {
		System.out.print("TEsteando");
		/*driver.get("file:///C:/Users/rmamani/eclipse-workspace/osde-selenium/drivers/web-demo-334d664191b71bd14366019c0df151644e75629d/university/login.html");
		
		List<WebElement> myList = driver.findElements(By.xpath("/html/body/ul/li"));
		System.out.println(myList.size());
		for(WebElement webElement : myList) {
			System.out.println(webElement.getText() + webElement.getLocation());
			if(webElement.getText().equals("c")) {
				System.out.println(webElement.getSize());
			}
		}
		
		//List<WebElement> cantInputs= driver.findElements(By.tagName("input)"));
		List<WebElement> cantInputs= driver.findElements(By.id("loginname"));
		System.out.print(cantInputs);*/
		
		
		
	
	}
}
