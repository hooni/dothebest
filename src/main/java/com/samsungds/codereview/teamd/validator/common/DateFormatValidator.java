package com.samsungds.codereview.teamd.validator.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.samsungds.codereview.teamd.validator.Validator;

public class DateFormatValidator implements Validator {
	
	private SimpleDateFormat format;
	
	public DateFormatValidator(String pattern) {
		this.format = new SimpleDateFormat(pattern);
	}

	public boolean isValid(String string) {
		if(string == null) return false;
		try {
			if(format.parse(string) != null) return true;
		} catch (ParseException ignore) {
		}
		return false;
	}

}
