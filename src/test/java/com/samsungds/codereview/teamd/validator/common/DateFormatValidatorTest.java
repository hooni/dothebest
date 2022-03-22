package com.samsungds.codereview.teamd.validator.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateFormatValidatorTest {
	DateFormatValidator validator;

	@BeforeEach
	void setUp() {
		validator = new DateFormatValidator("yyyyMMdd");
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
	void yyyymmddFormatTest() {
		assertEquals(false, validator.isValid("E0190415"));
	}

}
