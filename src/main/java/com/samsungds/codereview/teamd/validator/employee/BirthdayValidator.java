package com.samsungds.codereview.teamd.validator.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.samsungds.codereview.teamd.validator.Validator;

public class BirthdayValidator implements Validator {

	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public boolean isValid(String string) {
		if (string == null || string.trim().length() == 0 || string.trim().length() != 8)
			return false;
		try {
			if(format.parse(string) != null) return true;
		} catch (ParseException ignore) {
		}
		return false;
	}

}
