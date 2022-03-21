package com.samsungds.codereview.teamd.repo;

import com.samsungds.codereview.teamd.vo.Employee;

public class ExtractEmployee {
	public static String getEmpValue(Employee emp, String key) {
		return String.valueOf(EnumEmployee.valueOf(key).getValue(emp));
	}

	public static void putEmpValue(Employee emp, String key, String value) {
		EnumEmployee.valueOf(key).setValue(emp, value);
	}
}
