package ar.com.demo.basetest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ar.com.demo.portalCorporativo.servicios.SolicitarReintegro;


public class TestChromeBrowser extends BaseTest{

	private Login login;
	private Home home;
	private Portal portal;
	private Afiliado unAfiliado;
	private SolicitarReintegro servicioReintegro;
	
	@Test
	public void testeador() {
		driverTest.get("https://test.intranet.osde/IV3/login.asp");
		login = new Login(this.driverTest);
		login.loginToApplication("FT93855214", "intranet14");
			
		home = new Home(this.driverTest);
		home.goToUltimosAccessos();
		
		portal = new Portal(this.driverTest);
		portal.ingresarASuaPortal();
		unAfiliado = new Afiliado("Maravilla Luis");
		
		portal.buscarAfiliado(unAfiliado.getName());
		
		portal.buscarUnServicio("Solicitar Reintegro");
		
		
		servicioReintegro = new SolicitarReintegro(this.driverTest);
		
		servicioReintegro.esperar(6000);
		servicioReintegro.imprimirBeneficiarios();
		servicioReintegro.completarDatosFactura();
		
	}
	
}
