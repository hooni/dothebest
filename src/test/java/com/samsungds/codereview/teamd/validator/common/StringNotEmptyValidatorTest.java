package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringNotEmptyValidatorTest {

	StringNotEmptyValidator validator;

	@BeforeEach
	void setUp() {
		validator = new StringNotEmptyValidator();
	}

	@Test
	void validTest() {
		assertEquals(true, validator.isValid("123"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator.isValid(""));
	}
}
