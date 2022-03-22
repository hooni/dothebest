package com.samsungds.codereview.teamd.validator.common;

import java.util.regex.Pattern;

import com.samsungds.codereview.teamd.validator.Validator;

public class RegExValidator implements Validator {
	
	private String regex;
	
	public RegExValidator(String regex) {
		this.regex = regex;
	}

	public boolean isValid(String string) {
		return string != null && Pattern.matches(regex, string);
	}

}
