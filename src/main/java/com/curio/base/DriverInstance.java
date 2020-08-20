package com.curio.base;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DriverInstance {
	public WebDriver driver;
	public DriverInstance() {
		driver=null;
	}
	@BeforeClass
	public void intiateDriver() {
		driver=this.getChromeDriver();
		driver.get("http://localhost:8080/");
	}
	
	private WebDriver getChromeDriver() {
		ChromeDriverService service=new ChromeDriverService.Builder().usingDriverExecutable(new File("./src/main/resources/drivers/chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		ChromeDriver driver=new ChromeDriver(service);
		return driver;
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
