package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samsungds.codereview.teamd.constant.Constants;

public class StringSplitableValidatorTest {

	StringSplitableValidator validator;

	@BeforeEach
	void setUp() {
		validator = new StringSplitableValidator(Constants.SEPARATOR_NAME, 2);
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("123 12"));
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
