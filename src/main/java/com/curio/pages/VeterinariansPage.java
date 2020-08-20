package com.curio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.curio.base.DriverInstance;

public class VeterinariansPage {
	private final WebDriver driver;
	private final By veterinariansName= By.xpath("//tr/td[1]");
	private final By veterinariansSpecialties= By.xpath("//tr/td[2]");
	
	public VeterinariansPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String veterinariansNames(int index) {
		return driver.findElements(veterinariansName).get(index).getText();
	}
	public String veterinariansSpecialtiesText(int index) {
		return driver.findElements(veterinariansSpecialties).get(index).getText();
	}
}
