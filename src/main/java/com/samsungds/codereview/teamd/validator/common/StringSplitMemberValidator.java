package com.samsungds.codereview.teamd.validator.common;

import com.samsungds.codereview.teamd.validator.Validator;

public class StringSplitMemberValidator implements Validator {

	private String separator;
	private Validator[] validators;

	public StringSplitMemberValidator(String separator, Validator... validators) {
		this.separator = separator;
		this.validators = validators;
	}

	public boolean isValid(String string) {
		if (string == null) return false;
		String[] splitString = string.split(separator);
		if (validators.length != splitString.length) return false;
		for (int i = 0; i < validators.length; i++) {
			if (validators[i] == null) continue;
			if (!validators[i].isValid(splitString[i]))
				return false;
		}
		return true;
	}

}
