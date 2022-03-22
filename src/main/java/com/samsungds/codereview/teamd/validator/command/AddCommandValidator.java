package com.samsungds.codereview.teamd.validator.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.EmployeeValidator;
import com.samsungds.codereview.teamd.validator.Validator;

public class AddCommandValidator implements Validator {

	@Override
	public boolean isValid(String string) {
		if (string == null || string.trim().length() == 0) return false;
		String[] command = string.split(Constants.SEPARATOR_EMPLOYEE);
		if (!(command[Constants.INPUT_STR_COMMAND_POS].equals(Constants.COMMAND_ADD))) return false;
		if (command.length != 10) return false;
		if(!EmployeeValidator.EMPLOYEENUM.validate(command[Constants.INPUT_STR_EMP_NUM_POS])) return false;
		if(!EmployeeValidator.NAME.validate(command[Constants.INPUT_STR_EMP_NAME_POS])) return false;
		if(!EmployeeValidator.CL.validate(command[Constants.INPUT_STR_EMP_CAREER_LEVEL_POS])) return false;
		if(!EmployeeValidator.PHONENUM.validate(command[Constants.INPUT_STR_EMP_PHONENUM_POS])) return false;
		if(!EmployeeValidator.BIRTHDAY.validate(command[Constants.INPUT_STR_EMP_BIRTHDAY_POS])) return false;
		if(!EmployeeValidator.CERTI.validate(command[Constants.INPUT_STR_EMP_CERTI_POS])) return false;
		return true;
	}

}
