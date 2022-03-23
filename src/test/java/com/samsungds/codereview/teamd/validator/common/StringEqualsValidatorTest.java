package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringEqualsValidatorTest {

	StringEqualsValidator validator;

	@BeforeEach
	void setUp() {
		validator = new StringEqualsValidator("TEST");
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("TEST"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator.isValid("123456"));
		assertEquals(false, validator.isValid("123 4 56"));
	}

}
