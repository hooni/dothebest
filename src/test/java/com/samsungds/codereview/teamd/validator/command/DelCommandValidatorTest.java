package com.samsungds.codereview.teamd.validator.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DelCommandValidatorTest {

	DelCommandValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new DelCommandValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("DEL, , , ,employeeNum,18115040"));
	}
	
	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("DEL, , , ,employeeNum,18115040, 1"));
		assertEquals(false, validator.isValid("DEL, , , ,employeeNum"));
	}

}
