package com.samsungds.codereview.teamd.validator.common;

import com.samsungds.codereview.teamd.validator.Validator;

public class StringLengthValidator implements Validator {

	private int min;
	private int max;

	public StringLengthValidator(int length) {
		this.min = length;
		this.max = length;
	}
	
	public StringLengthValidator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public boolean isValid(String string) {
		return string != null && string.length() >= min && string.length() <= max;
	}

}
