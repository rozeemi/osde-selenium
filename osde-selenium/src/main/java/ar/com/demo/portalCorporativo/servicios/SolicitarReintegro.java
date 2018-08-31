/**
 * 
 */
/**
 * @author rosalia.mamani.so
 *
 */
package ar.com.demo.portalCorporativo.servicios;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ar.com.demo.basetest.PageObject;


public class SolicitarReintegro extends PageObject{

	
	
	public SolicitarReintegro(WebDriver driver) {
		super(driver);
	}
	
	
	public void imprimirBeneficiarios() {
		//List<WebElement> beneficiarios = this.getDriver().findElements(By.xpath("//td[2]/select[@name='txt_beneficiario']"));
		
		this.getDriver().findElement(By.xpath("//tbody/tr/td[2]/select[@name='txt_beneficiario']")).click();
		//System.out.println(this.getDriver().findElement(By.xpath("//tbody/tr/td[2]/select[@name='txt_beneficiario']")).getText());
		Select beneficiarios = new Select (this.getDriver().findElement(By.xpath("//tbody/tr/td[2]/select[@name='txt_beneficiario']")));
		System.out.println(beneficiarios.getOptions().size());
		List<WebElement> listOptionsBeneficiarios = beneficiarios.getOptions();
				
		System.out.println("cantidad de beneficiarios: "+ listOptionsBeneficiarios.size());
		for (WebElement webElement : listOptionsBeneficiarios) {
			System.out.println(webElement.getText());
		}
	}
	
	public void completarDatosFactura() {
		this.getDriver().findElement(By.xpath("//tbody/tr/td[2]/select[@id='slt_tipo']")).click();
		Select tipoFactura = new Select(this.getDriver().findElement(By.xpath("//tbody/tr/td[2]/select[@id=\"slt_tipo\"]")));
		List<WebElement> listOptionsTipoFactura = tipoFactura.getOptions();
		for (WebElement webElement : listOptionsTipoFactura) {
			System.out.println(webElement.getText());
		}		
		int sizeTipoFacura = listOptionsTipoFactura.size();
		int randomNum = ThreadLocalRandom.current().nextInt(0, sizeTipoFacura);
		tipoFactura.selectByIndex(randomNum);
		
		
		randomNum = ThreadLocalRandom.current().nextInt(0, 4);
		
		this.getDriver().findElement(By.name("txt_nrocomp1")).sendKeys(Integer.toString(randomNum));
		
		
	}
	
	
}	