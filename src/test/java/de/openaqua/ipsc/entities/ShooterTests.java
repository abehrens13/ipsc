package de.openaqua.ipsc.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShooterTests {

	@Test
	public void testConstructors() throws Exception {
		Shooter a = new Shooter();
		Assertions.assertNull(a.getPassword());
		Assertions.assertNull(a.getDsgvoDate());
		Assertions.assertNull(a.getEmail());
		Assertions.assertNull(a.getId());
		Assertions.assertEquals(a.getCountry(), "DE");
	}

	@Test
	public void testGetterSetter() throws Exception {
		Shooter a = new Shooter();
		a.setCountry("FR");
		Assertions.assertEquals(a.getCountry(), "FR");
	}

}
