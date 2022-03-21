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
	public Integer add(Employee employee) {
		Integer employeeKey = getEmpKey(employee.getEmployeeNum());

		if (db.containsKey(employeeKey))
			return 0;

		// 추후 반영시 주석 해제.
//		emp.setEmployeeNumForSort(empKey.intValue());
		db.put(employeeKey, employee);

		return employeeKey;
	}

	@Override
	public Map<Integer, Employee> delete(String key, String value) {
		Map<Integer, Employee> result = new HashMap<>();

		Iterator<Integer> empNums = db.keySet().stream()
				.filter(k -> getEmpValue(db.get(k), key).equalsIgnoreCase(value)).iterator();
		while (empNums.hasNext()) {
			Integer empNum = empNums.next();
			result.put(empNum, db.remove(empNum));
		}

		return result;
	}

	@Override
	public Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue) {
		Map<Integer, Employee> result = new HashMap<>();

		Iterator<Integer> empNums = db.keySet().stream()
				.filter(k -> getEmpValue(db.get(k), targetKey).equalsIgnoreCase(targetValue)).iterator();
		while (empNums.hasNext()) {
			Integer empNum = empNums.next();
			Employee employee = db.get(empNum);
			result.put(empNum, new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(),
					employee.getPhoneNum(), employee.getBirthday(), employee.getCerti()));
			putEmpValue(employee, chageKey, changeValue);
		}
		return result;
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

	private String getEmpValue(Employee emp, String key) {
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

	private void putEmpValue(Employee emp, String key, String value) {
		try {
			Class<?> cls = Class.forName(Employee.class.getName());
			Method m = cls.getDeclaredMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
					String.class);
			m.invoke(emp, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
