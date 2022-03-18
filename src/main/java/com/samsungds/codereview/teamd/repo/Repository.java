package com.samsungds.codereview.teamd.repo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.vo.Employee;

public class Repository implements IRepository {

	private Map<Integer, Employee> db = new HashMap<>();

	@Override
	public Integer add(Employee emp) {
		Integer empKey = getEmpKey(emp.getEmployeeNum());

		if (db.containsKey(empKey))
			return 0;

		// ���� �ݿ��� �ּ� ����.
//		emp.setEmployeeNumForSort(empKey.intValue());
		db.put(empKey, emp);

		return empKey;
	}

	@Override
	public Map<Integer, Employee> delete(String key, String value) {
		Map<Integer, Employee> result = new HashMap<>();

		Iterator<Integer> empNums = db.keySet().stream().filter(k -> getEmpValue(db.get(k), key).equalsIgnoreCase(value)).iterator();
		while(empNums.hasNext()) {
			Integer empNum = empNums.next();
			result.put(empNum, db.remove(empNum));
		}

		return result;
	}

	@Override
	public Map<Integer, Employee> modify(String anyString, String anyString2) {
		return null;
	}

	@Override
	public Map<Integer, Employee> search(String key, String value) {
		return null;
	}

	private Integer getEmpKey(String employeeNum) {
		char fWord = employeeNum.charAt(0);
		if (fWord > Constants.SEPARATOR_EMPLOYEE_NUM) {
			return Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_BEFORE_MILLENIUM + employeeNum);
		}
		return Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_AFTER_MILLENIUM + employeeNum);
	}

	public String getEmpValue(Employee emp, String key) {
		Object result = null;
		try {
			Class<?> cls = Class.forName(Employee.class.getName());
			Method m = cls.getDeclaredMethod("get" + key.substring(0, 1).toUpperCase() + key.substring(1));
			result = m.invoke(emp);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return "";
		}

		return String.valueOf(result);
	}
}
