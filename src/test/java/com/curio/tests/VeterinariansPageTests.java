package com.curio.tests;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curio.base.DriverInstance;
import com.curio.pages.HomePage;
import com.curio.pages.VeterinariansPage;

public class VeterinariansPageTests extends DriverInstance {
	VeterinariansPage veterinarian;
	HomePage home;
	InputStream datais;
	JSONObject veterinarians;
	JSONArray jdata;
	int length = 0;
	static String dataFileName = "testdata/testdata.json";
	
	@BeforeClass
	public void beforeClass() throws Exception {
		try {
			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokner = new JSONTokener(datais);
			veterinarians = new JSONObject(tokner);
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
		veterinarian = new VeterinariansPage(driver);
		home = new HomePage(driver);
		home.clickOnTab("Veterinarians");
		jdata = veterinarians.getJSONArray("veterinarians");
		length = jdata.length();
	}

	@Test(description="Validate Veterinarians names")
	public void validateVenName() {
		for (int i = 0; i < length; i++) {
			Assert.assertEquals(veterinarian.veterinariansNames(i), jdata.getJSONObject(i).getString("name"));
		}
	}

	@Test(description="Validate Veterinarians specialities")
	public void validateVenSepcl() {
		for (int i = 0; i < length; i++) {
			Assert.assertEquals(veterinarian.veterinariansSpecialtiesText(i), jdata.getJSONObject(i).getString("Specialties"));
		}
	}

}
