package ar.com.demo.basetest;

import org.openqa.selenium.By;


public class Afiliado {
	private String name;
	private String numero;
	
	public Afiliado(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.setName(name);
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	 
	public void buscar(PageObject driver) {
		driver.getDriver().findElement(By.id("queryStringInput")).sendKeys(this.getName());
		
		driver.getDriver().findElement(By.id("lupaSearchDiv")).click();
		driver.esperar(2500);
	}
	
	
}
