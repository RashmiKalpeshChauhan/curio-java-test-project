package com.curio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  {
	private final WebDriver driver;
	private final By img= By.xpath("//img[@src='/resources/images/pets.png']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public int isImgPresent() {
		return driver.findElements(img).size();
	} 
	public void clickOnTab(String tab) {
		driver.findElement(By.xpath("//span[text()='"+tab+"']")).click();
		
	}

}
