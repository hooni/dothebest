package com.samsungds.codereview.teamd.validator.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModCommandValidatorTest {

	ModCommandValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new ModCommandValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("MOD,-p, , ,name,FB NTAWR,birthday,20050520"));
	}
	
	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("MOD,-p, , ,name,FB NTAWR,birthday,20050520,1"));
		assertEquals(false, validator.isValid("MOD,-p, , ,name,FB NTAWR,birthday"));
	}
	
	@Test
	void formatTest() {
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("MOD,-p, , ,name,FB NTAWR,unknown,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("MOD,-p, , ,name,FB NTAWR,name,20050520"));
		assertEquals(false, validator.isValid("MOD,-p, , ,name,FB NTAWR,employeeNum,2005E520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("MOD,-p, , ,name,FB NTAWR,cl,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("MOD,-p, , ,name,FB NTAWR,phoneNum,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("MOD,-p, , ,name,FB NTAWR,birthday,200505202"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("MOD,-p, , ,name,FB NTAWR,certi,20050520"));
	}

}
