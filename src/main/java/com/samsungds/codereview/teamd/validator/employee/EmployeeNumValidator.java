package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.validator.Validator;

public class EmployeeNumValidator implements Validator {

	@Override
	public boolean isValid(String string) {
		if (string == null || string.trim().length() == 0 || string.trim().length() != 8)
			return false;
		try {
			int number = Integer.parseInt(string);
			if (number >= 69000000 || number < 22000000)
				return true;
		} catch (NumberFormatException ignore) {
		}

		return false;
	}

}
