package com.samsungds.codereview.teamd.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class EmployeeValidatorTest {

	@Test
	void employeeNumTest() {
		EmployeeValidator validator = EmployeeValidator.EMPLOYEENUM;
		assertEquals(true, validator.validate("10193121"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("1019312"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("101931211"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("68999999"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("22000000"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("6999999O"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("E1000000"));
	}

	@Test
	void nameTest() {
		EmployeeValidator validator = EmployeeValidator.NAME;
		assertEquals(true, validator.validate("WONGEUN LEE"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("LLLLLLLLL LLLLL"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("LLLLLLLLL LL LL"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("LLLLLLLLLLLLLLL"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("LLLLLL LL8"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("LLLLL LLe"));
	}

	@Test
	void clTest() {
		EmployeeValidator validator = EmployeeValidator.CL;
		assertEquals(true, validator.validate("CL1"));
		assertEquals(true, validator.validate("CL2"));
		assertEquals(true, validator.validate("CL3"));
		assertEquals(true, validator.validate("CL4"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate(null));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("CL"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("CL33"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("CE3"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("CL5"));
	}

	@Test
	void phoneNumTest() {
		EmployeeValidator validator = EmployeeValidator.PHONENUM;
		assertEquals(true, validator.validate("010-4444-5555"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("010-444-5555"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("010-44444-555"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("010-4-44-5555"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("01044444-5555"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("011-4444-5555"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("010-4444-E555"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("010-444E-5555"));
	}

	@Test
	void birthdayTest() {
		EmployeeValidator validator = EmployeeValidator.BIRTHDAY;
		assertEquals(true, validator.validate("20190415"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate(null));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("2019041"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("201904155"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("E0190415"));
	}

	@Test
	void certiTest() {
		EmployeeValidator validator = EmployeeValidator.CERTI;
		assertEquals(true, validator.validate("ADV"));
		assertEquals(true, validator.validate("PRO"));
		assertEquals(true, validator.validate("EX"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate(null));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("AD"));
		assertThrows(IllegalArgumentException.class, () -> validator.validate("EXP"));
	}

}
