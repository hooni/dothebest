package com.samsungds.codereview.teamd.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.samsungds.codereview.teamd.constant.Constants;

public class CommandValidatorTest {

	@Test
	void addTest() {
		CommandValidator validator = CommandValidator.ADD;
		assertEquals(true, validator.validate("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate(null));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV,1"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,151E3099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,15123099,VXIHX TH JHOP,CL3,010-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,15123099,VXIHXOTH JHOP,CL5,010-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,011-3112-2609,19771211,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,197712111,ADV"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,EXP"));
	}

	@Test
	void modTest() {
		CommandValidator validator = CommandValidator.MOD;
		assertEquals(true, validator.validate("MOD,-p, , ,name,FB NTAWR,birthday,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate(null));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,birthday,20050520,1"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,birthday"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,unknown,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,name,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,employeeNum,2005E520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,cl,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,phoneNum,20050520"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,birthday,200505202"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("MOD,-p, , ,name,FB NTAWR,certi,20050520"));
	}

	@Test
	void schTest() {
		CommandValidator validator = CommandValidator.SCH;
		assertEquals(true, validator.validate("SCH, , , ,employeeNum,79110836"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate(null));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("SCH, , , ,employeeNum,79110836,1"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("SCH, , , ,employeeNum"));
	}

	@Test
	void delTest() {
		CommandValidator validator = CommandValidator.DEL;
		assertEquals(true, validator.validate("DEL, , , ,employeeNum,18115040"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate(null));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("DEL, , , ,employeeNum,18115040, 1"));
		assertThrows(IllegalArgumentException.class, ()-> validator.validate("DEL, , , ,employeeNum"));
	}

	@Test
	void getValidatorTest() {
		assertEquals(true, CommandValidator.getValidator(Constants.COMMAND_ADD) == CommandValidator.ADD);
		assertEquals(true, CommandValidator.getValidator(Constants.COMMAND_DEL) == CommandValidator.DEL);
		assertEquals(true, CommandValidator.getValidator(Constants.COMMAND_MODIFY) == CommandValidator.MOD);
		assertEquals(true, CommandValidator.getValidator(Constants.COMMAND_SEARCH) == CommandValidator.SCH);
		assertThrows(IllegalArgumentException.class, () -> CommandValidator.getValidator(null));
		assertThrows(IllegalArgumentException.class, () -> CommandValidator.getValidator(Constants.NO_DATA));
	}

}
