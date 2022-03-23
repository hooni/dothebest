package com.samsungds.codereview.teamd.validator.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.EmployeeValidator;
import com.samsungds.codereview.teamd.validator.common.StringEqualsValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEqualsValidator;
import com.samsungds.codereview.teamd.validator.common.StringSplitMemberValidator;

public class ModCommandValidator extends CompositeValidator {
	
	public ModCommandValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringSplitMemberValidator(Constants.SEPARATOR_EMPLOYEE,
				new StringEqualsValidator(Constants.COMMAND_MODIFY), null, null, null, null, null, 
				new StringNotEqualsValidator(Constants.EMPLOYEE_NUM), null));
		addValidator((string) -> {
			String[] command = string.split(Constants.SEPARATOR_EMPLOYEE);
			if(!EmployeeValidator.getValidator(command[Constants.INPUT_STR_KEY2]).validate(command[Constants.INPUT_STR_VALUE2])) return false;
			return true;
		});
	}
}
