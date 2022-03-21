package com.samsungds.codereview.teamd.validator.employee;

import java.util.regex.Pattern;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.Validator;

public class NameValidator implements Validator {

	private static final String REGEX_UPPERCASE_ALPHABET = "^[A-Z]*$"; 
	@Override
	public boolean isValid(String string) {
		if(string == null || string.trim().length() == 0 || string.trim().length() >= 15) return false;
		String[] split = string.split(Constants.SEPARATOR_NAME);
		if(split == null || split.length != 2) return false;
		for(String s : split) {
			if(Pattern.matches(REGEX_UPPERCASE_ALPHABET, s) == false) return false;
		}
		return true;
	}

}
