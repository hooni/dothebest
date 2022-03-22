package com.samsungds.codereview.teamd.validator.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NameValidatorTest {

	NameValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new NameValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("WONGEUN LEE"));
		assertEquals(true, validator.isValid("JOSEPH WILLIAMS"));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("LLLLLLLLL LLLLLL"));
	}
	
	@Test
	void splitTest() {
		assertEquals(false, validator.isValid("LLLLLLLLL LL LL"));
		assertEquals(false, validator.isValid("LLLLLLLLLLLLLLLL"));
	}
	
	@Test
	void isUppercateTest() {
		assertEquals(false, validator.isValid("LLLLLL LL8"));
		assertEquals(false, validator.isValid("LLLLL LLe"));
	}
}
