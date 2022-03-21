package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.validator.Validator;

public class CertiValidator implements Validator {

	private static final String values[] = { "ADV", "PRO", "EX" };

	@Override
	public boolean isValid(String string) {
		if (string == null)
			return false;
		for (String s : values) {
			if (s.equals(string))
				return true;
		}
		return false;
	}

}
