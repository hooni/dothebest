package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegExValidatorTest  {
	RegExValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new RegExValidator("^[A-Z\\s]*$");
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("AB CD"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator.isValid("AB Cd"));
	}
	
}
