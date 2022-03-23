package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.RegExValidator;
import com.samsungds.codereview.teamd.validator.common.StringLengthValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;
import com.samsungds.codereview.teamd.validator.common.StringSplitableValidator;

public class NameValidator extends CompositeValidator {

	private static final String REGEX_UPPERCASE_ALPHABET = "^[A-Z\\s]*$";
	private static final int NAME_MIN_LENGTH = 1;
	private static final int NAME_MAX_LENGTH = 15;
	private static final int NAME_SPLIT_LENGTH = 2;

	public NameValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringLengthValidator(NAME_MIN_LENGTH, NAME_MAX_LENGTH));
		addValidator(new StringSplitableValidator(Constants.SEPARATOR_NAME, NAME_SPLIT_LENGTH));
		addValidator(new RegExValidator(REGEX_UPPERCASE_ALPHABET));
	}

}
