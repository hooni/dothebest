package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringLengthValidatorTest {
	StringLengthValidator validator1;
	StringLengthValidator validator2;

	@BeforeEach
	void setUp() {
		validator1 = new StringLengthValidator(8, 8);
		validator2 = new StringLengthValidator(8);
	}

	@Test
	void validTest() {
		assertEquals(true, validator1.isValid("12345678"));
		assertEquals(true, validator2.isValid("12345678"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator1.isValid(null));
		assertEquals(false, validator2.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator1.isValid("123456789"));
		assertEquals(false, validator1.isValid("1234567"));
		assertEquals(false, validator2.isValid("123456789"));
		assertEquals(false, validator2.isValid("1234567"));
	}

}
