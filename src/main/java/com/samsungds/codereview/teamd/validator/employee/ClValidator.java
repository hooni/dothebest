package com.samsungds.codereview.teamd.validator.employee;

import com.samsungds.codereview.teamd.validator.CompositeValidator;
import com.samsungds.codereview.teamd.validator.common.StringContainValidator;
import com.samsungds.codereview.teamd.validator.common.StringNotEmptyValidator;

public class ClValidator extends CompositeValidator {

	private static final String values[] = { "CL1", "CL2", "CL3", "CL4" };
	
	public ClValidator() {
		addValidator(new StringNotEmptyValidator());
		addValidator(new StringContainValidator(values));
	}

}
