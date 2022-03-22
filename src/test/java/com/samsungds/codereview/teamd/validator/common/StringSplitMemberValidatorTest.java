package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSplitMemberValidatorTest {

	StringSplitMemberValidator validator;

	@BeforeEach
	void setUp() {
		validator = new StringSplitMemberValidator(",", new StringEqualsValidator("TEST"), null, new StringLengthValidator(4));
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("TEST,,1234"));
	}

	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}

	@Test
	void notValidTest() {
		assertEquals(false, validator.isValid("TEST,1234,1"));
		assertEquals(false, validator.isValid("TEST"));
	}

}
