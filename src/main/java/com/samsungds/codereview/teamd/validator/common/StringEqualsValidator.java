package com.samsungds.codereview.teamd.validator.common;

import com.samsungds.codereview.teamd.validator.Validator;

public class StringEqualsValidator implements Validator {

	private String string;

	public StringEqualsValidator(String string) {
		this.string = string;
	}

	public boolean isValid(String string) {
		return string != null && string.equals(this.string);
	}

}
