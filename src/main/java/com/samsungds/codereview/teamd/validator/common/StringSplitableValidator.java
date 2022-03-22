package com.samsungds.codereview.teamd.validator.common;

import com.samsungds.codereview.teamd.validator.Validator;

public class StringSplitableValidator implements Validator {

	private String separator;
	private int length;

	public StringSplitableValidator(String separator, int length) {
		this.separator = separator;
		this.length = length;
	}

	public boolean isValid(String string) {
		return string != null && string.split(separator).length == length;
	}

}
