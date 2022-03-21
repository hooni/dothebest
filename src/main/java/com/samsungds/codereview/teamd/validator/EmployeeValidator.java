package com.samsungds.codereview.teamd.validator;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.employee.BirthdayValidator;
import com.samsungds.codereview.teamd.validator.employee.CertiValidator;
import com.samsungds.codereview.teamd.validator.employee.ClValidator;
import com.samsungds.codereview.teamd.validator.employee.EmployeeNumValidator;
import com.samsungds.codereview.teamd.validator.employee.NameValidator;
import com.samsungds.codereview.teamd.validator.employee.PhoneNumValidator;

public class EmployeeValidator {

	public static final EmployeeValidator EMPLOYEENUM = new EmployeeValidator(Constants.EMPLOYEE_NUM, new EmployeeNumValidator());
	public static final EmployeeValidator NAME = new EmployeeValidator(Constants.EMPLOYEE_NAME, new NameValidator());
	public static final EmployeeValidator CL = new EmployeeValidator(Constants.EMPLOYEE_CAREER_LEVEL, new ClValidator());
	public static final EmployeeValidator PHONENUM = new EmployeeValidator(Constants.EMPLOYEE_PHONENUM, new PhoneNumValidator());
	public static final EmployeeValidator BIRTHDAY = new EmployeeValidator(Constants.EMPLOYEE_BIRTHDAY, new BirthdayValidator());
	public static final EmployeeValidator CERTI = new EmployeeValidator(Constants.EMPLOYEE_CERTI, new CertiValidator());

	private Validator validator;
	private String name;

	private EmployeeValidator(String name, Validator validator) {
		this.name = name;
		this.validator = validator;
	}

	public boolean validate(String value) {
		if (validator.isValid(value) == false) {
			throw new IllegalArgumentException(name + " : " + value);
		}
		return true;
	}
}
