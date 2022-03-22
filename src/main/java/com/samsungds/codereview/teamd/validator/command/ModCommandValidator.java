package com.samsungds.codereview.teamd.validator.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.EmployeeValidator;
import com.samsungds.codereview.teamd.validator.Validator;

public class ModCommandValidator implements Validator {

	@Override
	public boolean isValid(String string) {
		if (string == null || string.trim().length() == 0) return false;
		String[] command = string.split(Constants.SEPARATOR_EMPLOYEE);
		if (!(command[Constants.INPUT_STR_COMMAND_POS].equals(Constants.COMMAND_MODIFY))) return false;
		if (command.length != 8) return false;
		if (command[Constants.INPUT_STR_KEY2].equals(Constants.EMPLOYEE_NUM)) return false;
		if(!EmployeeValidator.getValidator(command[Constants.INPUT_STR_KEY2]).validate(command[Constants.INPUT_STR_VALUE2])) return false;
		return true;
	}

}
