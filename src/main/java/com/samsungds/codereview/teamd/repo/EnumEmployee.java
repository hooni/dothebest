package com.samsungds.codereview.teamd.repo;

import com.samsungds.codereview.teamd.vo.Employee;

public enum EnumEmployee {
	employeeNum {
		@Override
		Object getValue(Employee employee) {
			return employee.getEmployeeNum();
		}
	},
	name {
		@Override
		Object getValue(Employee employee) {
			return employee.getName();
		}

		@Override
		void setValue(Employee employee, String value) {
			employee.setName(value);
		}
	},
	cl {
		@Override
		Object getValue(Employee employee) {
			return employee.getCl();
		}

		@Override
		void setValue(Employee employee, String value) {
			employee.setCl(value);
		}
	},
	phoneNum {
		@Override
		Object getValue(Employee employee) {
			return employee.getPhoneNum();
		}

		@Override
		void setValue(Employee employee, String value) {
			employee.setPhoneNum(value);
		}
	},
	birthday {
		@Override
		Object getValue(Employee employee) {
			return employee.getBirthday();
		}

		@Override
		void setValue(Employee employee, String value) {
			employee.setBirthday(value);
		}
	},
	certi {
		@Override
		Object getValue(Employee employee) {
			return employee.getCerti();
		}

		@Override
		void setValue(Employee employee, String value) {
			employee.setCerti(value);
		}
	},
	nameFirst {
		@Override
		Object getValue(Employee employee) {
			return employee.getNameFirst();
		}
	},
	nameLast {
		@Override
		Object getValue(Employee employee) {
			return employee.getNameLast();
		}
	},
	phoneNumMid {
		@Override
		Object getValue(Employee employee) {
			return employee.getPhoneNumMid();
		}
	},
	phoneNumLast {
		@Override
		Object getValue(Employee employee) {
			return employee.getPhoneNumLast();
		}
	},
	birthdayYear {
		@Override
		Object getValue(Employee employee) {
			return employee.getBirthdayYear();
		}
	},
	birthdayMonth {
		@Override
		Object getValue(Employee employee) {
			return employee.getBirthdayMonth();
		}
	};

	abstract Object getValue(Employee employee);

	void setValue(Employee employee, String value) {
	}
}
