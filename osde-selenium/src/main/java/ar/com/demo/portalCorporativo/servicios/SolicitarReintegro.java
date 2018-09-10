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

import ar.com.demo.basetest.Portal;


public class SolicitarReintegro extends Portal{

	
	
	public SolicitarReintegro(WebDriver driver) {
		super(driver);
	}
	
	
	public void imprimirBeneficiarios() {
		try {
			this.getDriver().switchTo().frame("iframesuaServicioWidget");
			
			String path = "//td[2]/select[@name='txt_beneficiario']";
			System.out.println("page: "+ this.getDriver().getTitle());
			imprimirSelect(path,false);
			
		}catch(Exception e){
			System.out.println(e);
			
		}
	}
	
	public void completarDatosFactura() {
		String path ="//tbody/tr/td[2]/select[@id='slt_tipo']";
		imprimirSelect(path,true); //tipoFactura
		
		//nro de factura
		setearRandom("txt_nrocomp1",999);
		setearRandom("txt_nrocomp2",999);
		//fecha
		setearRandom("txt_dia_fact",30);
		setearRandom("txt_mes_fact",8); 
		
		
		setearRandom("txt_importecomp",100); 
		
		if (!this.getDriver().findElement(By.id("chk_medicamentos")).isSelected()) {
			this.getDriver().findElement(By.id("chk_medicamentos")).click();
		}
		this.getDriver().findElement(By.id("txt_cuit1")).sendKeys("33");
		this.getDriver().findElement(By.id("txt_cuit2")).sendKeys("33333333");
		this.getDriver().findElement(By.id("txt_cuit3")).sendKeys("9");
		
		this.getDriver().findElement(By.id("btn_continuar")).click();
		
	}
	
	public void setearRandom(String id, int max) {
		String random = String.valueOf(ThreadLocalRandom.current().nextInt(1, max));
		this.getDriver().findElement(By.id(id)).sendKeys(random);
	}
	
	public void imprimirSelect(String path, boolean random) {
		this.getDriver().findElement(By.xpath(path)).click();
		Select select = new Select(this.getDriver().findElement(By.xpath(path)));
		System.out.println("Cantidad de opciones: "+select.getOptions().size());
		List<WebElement> listOptions = select.getOptions();
		System.out.println("Opciones: ");
		for (WebElement webElement : listOptions) {
			System.out.println(webElement.getText());
		}		
		if(random) {
			this.esperar(1000);
			int size = listOptions.size();
			int randomNum = ThreadLocalRandom.current().nextInt(1, size); // deberia empezar desde 0
			select.selectByIndex(randomNum);
			System.out.println("Random: true.");
			System.out.println("Se seleccionó la opcion : "+ select.getFirstSelectedOption().getText());
		}
		System.out.println("");
			
		
	}
	public void elegirProfesional(String codigoPrestacion) {
		String path="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/form[2]/center/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[2]";
		
		this.getDriver().findElement(By.xpath(path)).click();
		//String codigo = ""
		this.getDriver().findElement(By.xpath("/html//a[@id='seleccionar']")).click();
		this.getDriver().findElement(By.id("txt_codigo")).sendKeys(codigoPrestacion);
		System.out.println("Prestacion ingresada: "+codigoPrestacion);
		this.getDriver().findElement(By.id("eventSubmit_doAgregar")).click();
		System.out.println("Importe valorizado: "+this.getDriver().findElement(By.id("txt_importe")).getCssValue("value"));
		this.getDriver().findElement(By.id("eventSubmit_doAgregar")).click();
		
		////body/table/tbody/tr/td/table/tbody/tr[5]/td/table//input[@name='eventSubmit_doValorizar']
		this.getDriver().findElement(By.xpath("//body/table/tbody/tr/td/table/tbody/tr[5]/td/table//input[@name='eventSubmit_doValorizar']")).click(); //btn continuar
		
		if(!(this.getDriver().findElements(By.xpath("//form[@id='formRegistracion']/center/table/tbody/tr[5]/td/center/table/tbody[1]/tr/td[2]/table//tr/td[2]/input[2]")).size()>0)) {
			
			this.getDriver().findElement(By.xpath("//*[@id=\"modificar\"]/img")).click();
			this.getDriver().findElement(By.xpath("//table[@id='autorizacion']/tbody/tr/td/center/table/tbody/tr[3]/td/table[@class='bordePaginado']/tbody/tr/td[1]/table//tr[@class='columnaTablaABMPar1']//input[@name='txtUsuario']")).sendKeys("rein"); //
			this.getDriver().findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("rein");
			this.getDriver().findElement(By.xpath("//tr[@id='trBotones']//center/table/tbody/tr/td[1]/table//input[@name='eventSubmit_doGrabar']")).click();
			this.getDriver().findElement(By.xpath("//form[@id='formRegistracion']/center/table/tbody/tr[5]/td/center/table/tbody[1]/tr/td[1]/table//input[@name='eventSubmit_doPrestaciones']")).click();
			
		}
		this.getDriver().findElement(By.xpath("//form[@id='formRegistracion']/center/table/tbody/tr[5]/td/center/table/tbody[1]/tr/td[2]/table//tr/td[2]/input[2]")).click(); //btn fin de reintegro
		
		//forma de pago
		this.getDriver().findElement(By.xpath("//*[@id=\"formRegistracion\"]/center/table/tbody/tr[9]/td/center/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/a")).click();
		this.getDriver().findElement(By.xpath("//form[@id='formRegistracion']/center/table/tbody/tr[19]/td/table//input[@name='eventButton_doContinuar']")).click();
	
		this.getDriver().findElement(By.xpath("/html//button[@id='boton0']")).click();//btn Aceptar portal
	
		System.out.println(this.getDriver().findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/form/center/table/tbody/tr[5]/td/table/tbody/tr[8]/td")).getText()); // nro de reintegro
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	