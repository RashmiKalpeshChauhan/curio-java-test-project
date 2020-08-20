package com.curio.tests;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.curio.base.DriverInstance;
import com.curio.pages.HomePage;


public class HomePageTests extends DriverInstance {
	HomePage home;
	
	@BeforeMethod
	public void beforeMethod(Method m) {		
		home=new HomePage(driver);
	}
	@Test(description="Validate image is present on screen or not")
	public void validateImgPresent() {		
		home.clickOnTab("Home");
		Assert.assertEquals(home.isImgPresent(),1,"Image is not present on home page");
	}
}
