package com.samsungds.codereview.teamd.validator.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchCommandValidatorTest {

	SchCommandValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new SchCommandValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("SCH, , , ,employeeNum,79110836"));
	}
	
	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("SCH, , , ,employeeNum,79110836,1"));
		assertEquals(false, validator.isValid("SCH, , , ,employeeNum"));
	}

}
