package com.samsungds.codereview.teamd.validator.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneNumValidatorTest {

	PhoneNumValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new PhoneNumValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("010-4444-5555"));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("010-444-5555"));
		assertEquals(false, validator.isValid("010-44444-555"));
	}
	
	@Test
	void formatTest() {
		assertEquals(false, validator.isValid("010-4-44-5555"));
		assertEquals(false, validator.isValid("01044444-5555"));
		assertEquals(false, validator.isValid("011-4444-5555"));
	}
	
	@Test
	void isNumericTest() {
		assertEquals(false, validator.isValid("010-4444-E555"));
		assertEquals(false, validator.isValid("010-444E-5555"));
	}

}
