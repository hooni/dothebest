package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.RegExValidator;
import com.samsungds.codereview.teamd.validator.common.StringLengthValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;
import com.samsungds.codereview.teamd.validator.common.StringSplitableValidator;

public class PhoneNumValidator extends CompositeValidator {

	private static final String REGEX_PHONENUM = "010-\\d{4}-\\d{4}";
	private static final int PHONENUM_LENGTH = 13;
	private static final int PHONENUM_SPLIT_LENGTH = 3;

	public PhoneNumValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringLengthValidator(PHONENUM_LENGTH));
		addValidator(new StringSplitableValidator(Constants.SEPARATOR_PHONENUM, PHONENUM_SPLIT_LENGTH));
		addValidator(new RegExValidator(REGEX_PHONENUM));
	}
}
