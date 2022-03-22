package com.samsungds.codereview.teamd.validator.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.StringEqualsValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;
import com.samsungds.codereview.teamd.validator.common.StringSplitMemberValidator;

public class DelCommandValidator extends CompositeValidator {
	
	public DelCommandValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringSplitMemberValidator(Constants.SEPARATOR_EMPLOYEE,
				new StringEqualsValidator(Constants.COMMAND_DEL), null, null, null, null, null));
	}
}
