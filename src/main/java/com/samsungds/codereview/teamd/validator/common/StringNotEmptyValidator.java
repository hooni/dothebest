package com.samsungds.codereview.teamd.validator.common;

import com.samsungds.codereview.teamd.validator.Validator;

public class StringNotEmptyValidator implements Validator {

	public boolean isValid(String string) {
		return string != null && string.trim().length() > 0;
	}

}
