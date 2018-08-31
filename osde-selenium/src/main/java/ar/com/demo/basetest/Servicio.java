package ar.com.demo.basetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Servicio extends PageObject {
	public Servicio(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String name;
	//private WebDriver driver;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public void buscar(PageObject driver) { 
		
		driver.getDriver().findElement(By.id("collapsableLeftContainer")).click();
		driver.getDriver().findElement(By.id("servicesSearchInput")).sendKeys(this.getName());
		
		//List<WebElement> listOptions = driver.getDriver().findElements(By.xpath("//body/ul[3]"));
		
		
		System.out.println("Se ingreso al servicio " + this.getName());
		for (WebElement webElement : listOptions) {  // verificar que el opcion elegida es la correcta
			System.out.println(webElement.findElement(By.tagName("li")).getText());
		}
		
		driver.getDriver().findElement(By.xpath("//body/ul[4]/li[1]/a/b")).click();
		
	}

	public void imprimirDatos(Portal portal) {
		System.out.println("entre  ");
		String path = "//form[@id='form_page1']/table/tbody/tr[5]/td/table[@class='bordePaginado']/tbody/tr/td/table/tbody/tr[1]/td[2]";
		String path2 = "//*[@id='form_page1']/table/tbody/tr[5]/td/table[@class='bordePaginado']/tbody/tr/td/table/tbody/tr[1]/td[@class='textoclaro2bold']";
		System.out.println(path2);
		System.out.println(portal.getDriver().findElement(By.xpath(path2)).getText());
		System.out.println("entre  2");
		System.out.println(portal.getDriver().findElement(By.xpath(path)).getText());
		
		System.out.println(portal.getDriver().findElement(By.xpath("//form[@id='form_page1']/table/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).getText());
		
		for (int i = 1; i < 6; i++) {
			System.out.println("aaa  "+i);
			path = "//form[@id='form_page1']/table/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr["+ i + "]/td[2]";
			System.out.println(portal.getDriver().findElement(By.xpath(path)).getText());
        }
		
		String path = "//*[@id=\\\"form_page1\\\"]/table/tbody/tr[5]/td/table/tbody/tr/td/table/tbody";
		List<WebElement> imprimir= portal.getDriver().findElements(By.xpath(path));
		for (WebElement webElement : imprimir) {
			System.out.println(webElement.getText());
		}
	}*/
	
}
