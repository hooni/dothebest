package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.validator.Validator;

public class ClValidator implements Validator {

	private static final String values[] = { "CL1", "CL2", "CL3", "CL4" };

	@Override
	public boolean isValid(String string) {
		if (string == null)
			return false;
		for (String s : values) {
			if (s.equals(string))
				return true;
		}
		return false;
	}


}
