package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsNumericValidatorTest {
	IsNumericValidator validator;

	@BeforeEach
	void setUp() {
		validator = new IsNumericValidator();
	}

	@Test
	void validTest() {
		assertEquals(true, validator.isValid("123"));
		assertEquals(true, validator.isValid("0"));
		assertEquals(true, validator.isValid("1234"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator.isValid("EEE"));
	}

}
