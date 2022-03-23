package com.samsungds.codereview.teamd.validator.common;

import com.samsungds.codereview.teamd.validator.Validator;

public class IsNumericValidator implements Validator {

	public boolean isValid(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException ignore) {
		}
		return false;
	}

}
