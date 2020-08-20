package com.curio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindOwnerPage {
	private final WebDriver driver;
	private final By lastNameid= By.id("lastName");
	private final By findOwnerBtnXpath=By.xpath("//button[@type='submit']");
	private final By addOwnerButton=By.xpath("//a[text()='Add Owner']");
	private final By firstNameid=By.id("firstName");
	private final By lastNameId=By.id("lastName");
	private final By addressId=By.id("address");
	private final By cityId=By.id("city");
	private final By telephoneId = By.id("telephone");
	private final By addOwnBtn=By.xpath("//button[text()='Add Owner']");
	private final By editOwnerBtn=By.xpath("//a[normalize-space() = 'Edit Owner']");
	private final By addNewPetBtn=By.xpath("//a[normalize-space() = 'Add New Pet']");
	private final By numberOfRows=By.xpath("//tbody/tr");
	private final By petName=By.id("name");
	private final By birthDate=By.id("birthDate");
	private final By typedropDown=By.id("type");
	private final By addPetButton=By.xpath("//button[text()='Add Pet']");
	
	public FindOwnerPage(WebDriver driver) {
		this.driver=driver;
	}
	public void enterLastname(String lstnm) {
		driver.findElement(lastNameid).sendKeys(lstnm);
	}
	public void clickFindOwnBtn() {
		driver.findElement(findOwnerBtnXpath).click();
	}
	private void clickAddOwnerButton() {
		driver.findElement(addOwnerButton).click();
	}
	private void enterFirstName(String fsttName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(firstNameid));
		driver.findElement(firstNameid).sendKeys(fsttName);
	}
	private void enterLastName(String lstnm) {
		driver.findElement(lastNameId).sendKeys(lstnm);
	}
	private void enterAddress(String addr) {
		driver.findElement(addressId).sendKeys(addr);
	}
	private void enterCity(String city) {
		driver.findElement(cityId).sendKeys(city);
	}
	private void enterTelephone(String phone) {
		driver.findElement(telephoneId).sendKeys(phone);
	}
	private void clickAddOwnButton() {
		driver.findElement(addOwnBtn).click();
	}
	public WebElement editOwnerButton() {
		return driver.findElement(editOwnerBtn);
	}
	public WebElement addNewPetButton() {
		return driver.findElement(addNewPetBtn);
	}
	public int numberOfRows() {
		return driver.findElements(numberOfRows).size();
	}
	public void enterPetName(String petname) {
		driver.findElement(petName).sendKeys(petname);
	}
	public void enterBirthdate(String birthdate) {
		driver.findElement(birthDate).sendKeys(birthdate);
	}
	
	public void selectType(String text) {
		new Select(driver.findElement(typedropDown)).selectByVisibleText(text);
	}
	public void clickAddPetButton() {
		driver.findElement(addPetButton).click();
	}
	public String getAddedText(int index) {
		return driver.findElements(By.xpath("//td/span[text()='Pillu']/parent::td/parent::tr/td")).get(index).getText();
	}
	public void createOwner(String fsttName, String lstnm, String addr, String city, String phone) {
		this.clickAddOwnerButton();
		this.enterFirstName(fsttName);
		this.enterLastname(lstnm);
		this.enterAddress(addr);
		this.enterCity(city);
		this.enterTelephone(phone);
		this.clickAddOwnButton();
	}
	public void addPet(String petname, String birthdate, String text) {
		this.addNewPetButton().click();
		this.enterPetName(petname);
		this.enterBirthdate(birthdate);
		this.selectType(text);
		this.clickAddPetButton();
	}
}
