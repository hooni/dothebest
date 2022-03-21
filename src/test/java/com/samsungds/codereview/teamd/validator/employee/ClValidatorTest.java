package com.samsungds.codereview.teamd.validator.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClValidatorTest {

	ClValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new ClValidator();
	}

	@Test
	void validTest() {
		assertEquals(true, validator.isValid("CL1"));
		assertEquals(true, validator.isValid("CL2"));
		assertEquals(true, validator.isValid("CL3"));
		assertEquals(true, validator.isValid("CL4"));
	}
	
	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("CL"));
		assertEquals(false, validator.isValid("CL33"));
	}
	
	@Test
	void formatTest() {
		assertEquals(false, validator.isValid("CE3"));
		assertEquals(false, validator.isValid("CL5"));
	}

}
