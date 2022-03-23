package com.samsungds.codereview.teamd.validator.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.EmployeeValidator;
import com.samsungds.codereview.teamd.validator.common.StringEqualsValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;
import com.samsungds.codereview.teamd.validator.common.StringSplitMemberValidator;

public class AddCommandValidator extends CompositeValidator {
	
	public AddCommandValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringSplitMemberValidator(Constants.SEPARATOR_EMPLOYEE, 
				new StringEqualsValidator(Constants.COMMAND_ADD),
				null,null,null,
				EmployeeValidator.EMPLOYEENUM,
				EmployeeValidator.NAME,
				EmployeeValidator.CL,
				EmployeeValidator.PHONENUM,
				EmployeeValidator.BIRTHDAY,
				EmployeeValidator.CERTI
				));
	}

}
