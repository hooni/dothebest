package com.samsungds.codereview.teamd.validator.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddCommandValidatorTest {

	AddCommandValidator validator;
	
	@BeforeEach
	void setUp() {
		validator = new AddCommandValidator();
	}
	
	@Test
	void validTest() {
		assertEquals(true, validator.isValid("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
	}
	
	@Test
	void notNullTest() {
		assertEquals(false, validator.isValid(null));
	}
	
	@Test
	void lengthTest() {
		assertEquals(false, validator.isValid("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,"));
		assertEquals(false, validator.isValid("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV,1"));
	}
	
	@Test
	void formatTest() {
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("ADD, , , ,151E3099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("ADD, , , ,15123099,VXIHX TH JHOP,CL3,010-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("ADD, , , ,15123099,VXIHXOTH JHOP,CL5,010-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,011-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,197712111,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.isValid("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,EXP"));
	}

}
