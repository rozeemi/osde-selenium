package ar.com.demo.basetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ar.com.demo.portalCorporativo.servicios.SolicitarReintegro;


public class Portal extends PageObject {
		
	WebElement campoServicio;
	
	public Portal(WebDriver driver) {
		super(driver);
	}

	
	public void ingresarASuaPortal() {

		this.getDriver().findElement(By.xpath("//*[@id=\"portals\"]/option[6]")).click();
		this.esperar(6500);
		this.getDriver().navigate().refresh();
		//autenticar que se ingreso a sua Portal correctamente
		System.out.println("Se ingreso a Portal Corporativo");
		
	}
	public void buscarAfiliado(String unAfiliado) {
		WebElement campoAfiliado = this.getDriver().findElement(By.id("queryStringInput"));
		campoAfiliado.sendKeys(unAfiliado);
		this.getDriver().findElement(By.id("lupaSearchDiv")).click();
		this.esperar(6500);
		System.out.println("La búsqueda del afiliado " + unAfiliado + " se realizo con éxito.");
	}

	


	public void buscarUnServicio(String unServicio) {
		this.getDriver().findElement(By.id("collapsableLeftContainer")).click();
		campoServicio = this.getDriver().findElement(By.id("servicesSearchInput"));
		campoServicio.sendKeys(unServicio);
		
		this.getDriver().findElement(By.xpath("//body//li[1]/a/b")).click();
		this.esperar(6500);
		System.out.println("Ingreso al Servicio: "+ unServicio);
	
	}
}
