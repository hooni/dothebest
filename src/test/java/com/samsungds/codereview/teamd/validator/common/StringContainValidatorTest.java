package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringContainValidatorTest {

	StringContainValidator validator;

	@BeforeEach
	void setUp() {
		validator = new StringContainValidator(new String[] {"CL1", "CL2"});
	}

	@Test
	void validTest() {
		assertEquals(true, validator.isValid("CL1"));
		assertEquals(true, validator.isValid("CL2"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator.isValid("123456789"));
		assertEquals(false, validator.isValid("1234567"));
	}


}
