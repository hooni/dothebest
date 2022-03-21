package com.samsungds.codereview.teamd.validator.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CertiValidatorTest {

	CertiValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new CertiValidator();
	}

	@Test
	void validTest() {
		assertEquals(true, validator.isValid("ADV"));
		assertEquals(true, validator.isValid("PRO"));
		assertEquals(true, validator.isValid("EX"));
	}
	
	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}
	
	@Test
	void formatTest() {
		assertEquals(false, validator.isValid("AD"));
		assertEquals(false, validator.isValid("EXP"));
	}

}
