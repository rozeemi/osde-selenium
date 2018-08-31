package ar.com.demo.basetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends PageObject{

	WebElement ultimosAccesosLi;
	
	public Home(WebDriver driver) {
		super(driver);
	} 
	
	public Home goToUltimosAccessos() {		
		
		int size = this.getDriver().findElements(By.tagName("frame")).size();
		System.out.println("Cantidad de iframes: "+size);
		
		this.getDriver().switchTo().frame("home");
		
		//click en ultimos accesos
		ultimosAccesosLi = this.getDriver().findElement(By.xpath("//*[@id=\"item\"]"));
		ultimosAccesosLi.click();
		
		this.esperar(1500);
		//click en el li > a
		this.getDriver().findElement(By.xpath("//*[@id=\"item\"]/ul/li[1]/a")).click();
		
		//ESPERO QUE CARGUE COMPLETAMENTE LA SEGUNDA PANTALLA
		this.esperar(16000);
		System.out.println("Ya pasaron los 12 segundos.");	
		
		String currentWindowHome = this.getDriver().getWindowHandle();
		System.out.println("Current Window Home: "+currentWindowHome);
		
		for(String subWindow : this.getDriver().getWindowHandles()) {
			this.getDriver().switchTo().window(subWindow);
		}
		
		
		//this.getDriver().get("http://tlnxwas14.intranet.osde:8180/interdomNew/");
		
		//CUANDO YA ESTOY EN LA NUEVA VENTANA BUSCO ELEMENTOS PARA VER SI ESTOY PARADO DONDE CORRESPONDE
	
		/*List<WebElement> miListaDeMenu= this.getDriver().findElements(By.xpath("//html//select[@id='portals']"));
		for (WebElement webElement : miListaDeMenu) {
			System.out.println("---- "+webElement.getText());
		}
		*/
		
		/*this.getDriver().findElement(By.xpath("//*[@id=\"portals\"]/option[6]")).click();
		this.esperar(6500);*/
		
		
		return this;
	}

}
