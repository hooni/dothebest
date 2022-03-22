package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.IsNumericValidator;
import com.samsungds.codereview.teamd.validator.common.StringLengthValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;

public class EmployeeNumValidator extends CompositeValidator {
	
	private static final int EMPLOYEE_NUM_LENGTH = 8;
	private static final int EMPLOYEE_NUM_LOWER_BODUNDS = 69000000;
	private static final int EMPLOYEE_NUM_UPPER_BODUNDS = 22000000;
	
	public EmployeeNumValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringLengthValidator(EMPLOYEE_NUM_LENGTH));
		addValidator(new IsNumericValidator());
		addValidator((string) -> {
			try {
				int number = Integer.parseInt(string);
				if (number >= EMPLOYEE_NUM_LOWER_BODUNDS || number < EMPLOYEE_NUM_UPPER_BODUNDS)
					return true;
			} catch (NumberFormatException ignore) {
			}
			return false;
		});
	}
}
