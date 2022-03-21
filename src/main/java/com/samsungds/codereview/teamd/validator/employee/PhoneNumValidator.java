package com.samsungds.codereview.teamd.validator.employee;

import java.util.regex.Pattern;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.Validator;

public class PhoneNumValidator implements Validator {

	private static final String REGEX_NUMERIC = "^[0-9]{4}$"; 
	@Override
	public boolean isValid(String string) {
		if(string == null || string.trim().length() == 0 || string.trim().length() != 13) return false;
		String[] split = string.split(Constants.SEPARATOR_PHONENUM);
		if(split == null || split.length != 3) return false;
		if("010".equals(split[0]) == false ) return false;
		if(Pattern.matches(REGEX_NUMERIC, split[1]) == false) return false;
		if(Pattern.matches(REGEX_NUMERIC, split[2]) == false) return false;
		return true;
	}

}
