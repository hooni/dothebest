package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringNotEqualsValidatorTest {

	StringNotEqualsValidator validator;

	@BeforeEach
	void setUp() {
		validator = new StringNotEqualsValidator("TEST");
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("TEST1"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator.isValid("TEST"));
	}

}
