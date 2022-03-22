package com.samsungds.codereview.teamd.validator.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.Validator;

public class DelCommandValidator implements Validator {

	@Override
	public boolean isValid(String string) {
		if (string == null || string.trim().length() == 0) return false;
		String[] command = string.split(Constants.SEPARATOR_EMPLOYEE);
		if (!(command[Constants.INPUT_STR_COMMAND_POS].equals(Constants.COMMAND_DEL))) return false;
		if (command.length != 6) return false;
		return true;
	}

}
