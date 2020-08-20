package com.curio.tests;

import java.io.InputStream;
import java.lang.reflect.Method;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.curio.base.DriverInstance;
import com.curio.pages.FindOwnerPage;
import com.curio.pages.HomePage;

public class FindOwnerPageTests extends DriverInstance {
	FindOwnerPage findOwner;
	HomePage home;
	JSONObject owners;
	JSONObject pet;
	InputStream datais;
	JSONObject jdata;
	int length = 0;
	static String dataFileName = "testdata/testdata.json";
	
	
	@BeforeClass
	public void beforeClass() throws Exception {
		try {
			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokner = new JSONTokener(datais);
			jdata = new JSONObject(tokner);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (datais != null) {
				datais.close();
			}
		}

	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		findOwner = new FindOwnerPage(driver);
		home = new HomePage(driver);
		owners = jdata.getJSONObject("owner info");	
		pet= jdata.getJSONObject("petinfo");
		home.clickOnTab("Find owners");
	}



	@Test(description = "Validate owner added,editowner button and addnewpet buttons should appear on page")
	public void validateownerAddedEditBtnDisplayed() {
		findOwner.createOwner(owners.getString("firstname"), owners.getString("lastname"), owners.getString("address"),
				owners.getString("city"), owners.getString("telephone"));
		Assert.assertTrue(findOwner.editOwnerButton().isDisplayed());
		Assert.assertTrue(findOwner.addNewPetButton().isDisplayed());
	}

	@Test(description = "Number of result should greater than 1 when owner is present")
	public void validateSearchFunctionality() {
		findOwner.enterLastname(owners.getString("lastname"));
		findOwner.clickFindOwnBtn();
		Assert.assertTrue(findOwner.numberOfRows() >= 1);
	}

	@Test(description = "Validate added information should correct")
	public void validateAddPetFuctionality() {		
		findOwner.createOwner(owners.getString("firstname"), owners.getString("lastname"), owners.getString("address"),
				owners.getString("city"), owners.getString("telephone"));
		findOwner.addPet(pet.getString("name"), pet.getString("bithdate"), pet.getString("type"));
		home.clickOnTab("Find owners");
		findOwner.enterLastname(owners.getString("lastname"));
		findOwner.clickFindOwnBtn();		
		Assert.assertEquals(findOwner.getAddedText(0), owners.getString("firstname")+" "+owners.getString("lastname"));
		Assert.assertEquals(findOwner.getAddedText(1), owners.getString("address"));
		Assert.assertEquals(findOwner.getAddedText(2), owners.getString("city"));
		Assert.assertEquals(findOwner.getAddedText(3), owners.getString("telephone"));
		Assert.assertEquals(findOwner.getAddedText(4), "Pillu");
	}
}
