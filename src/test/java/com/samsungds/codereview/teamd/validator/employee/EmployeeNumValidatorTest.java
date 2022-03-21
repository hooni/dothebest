package com.samsungds.codereview.teamd.validator.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeNumValidatorTest {

	EmployeeNumValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new EmployeeNumValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("10193121"));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("1019312"));
		assertEquals(false, validator.isValid("101931211"));
	}
	
	@Test
	void rangeTest() {
		assertEquals(false, validator.isValid("68999999"));
		assertEquals(false, validator.isValid("22000000"));
	}
	
	@Test
	void isNumericTest() {
		assertEquals(false, validator.isValid("6999999O"));
		assertEquals(false, validator.isValid("E1000000"));
	}
}
