package com.samsungds.codereview.teamd.validator.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.StringEqualsValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;
import com.samsungds.codereview.teamd.validator.common.StringSplitMemberValidator;

public class SchCommandValidator extends CompositeValidator {
	
	public SchCommandValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringSplitMemberValidator(Constants.SEPARATOR_EMPLOYEE,
				new StringEqualsValidator(Constants.COMMAND_SEARCH), null, null, null, null, null));
	}

}
