package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.DateFormatValidator;
import com.samsungds.codereview.teamd.validator.common.IsNumericValidator;
import com.samsungds.codereview.teamd.validator.common.StringLengthValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;

public class BirthdayValidator extends CompositeValidator {

	private static final int EMPLOYEE_BIRTHDAY_LENGTH = 8;
	private static final String EMPLOYEE_BIRTHDAY_PATTERN = "yyyyMMdd";
	
	public BirthdayValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringLengthValidator(EMPLOYEE_BIRTHDAY_LENGTH));
		addValidator(new IsNumericValidator());
		addValidator(new DateFormatValidator(EMPLOYEE_BIRTHDAY_PATTERN));
	}

}
