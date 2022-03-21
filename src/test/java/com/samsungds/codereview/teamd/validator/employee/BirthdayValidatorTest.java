package com.samsungds.codereview.teamd.validator.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BirthdayValidatorTest {

	BirthdayValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new BirthdayValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("20190415"));
	}
	
	@Test
	void notNullTest() {
		
		assertEquals(false, validator.isValid(null));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("2019041"));
		assertEquals(false, validator.isValid("201904155"));
	}
	
	@Test
	void yyyymmddFormatTest() {
		assertEquals(false, validator.isValid("E0190415"));
	}
	

}
