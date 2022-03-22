package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.StringContainValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;

public class CertiValidator extends CompositeValidator {

	private static final String values[] = { "ADV", "PRO", "EX" };

	public CertiValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringContainValidator(values));
	}

}
