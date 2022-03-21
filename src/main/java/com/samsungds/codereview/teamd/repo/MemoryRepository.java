package com.samsungds.codereview.teamd.repo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.vo.Employee;

public class MemoryRepository implements IRepository {

	Map<Integer, Employee> db = new HashMap<>();

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
		return delete(key, value, db.size());
	}

	@Override
	public Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue) {
		Map<Integer, Employee> result = new HashMap<>();

		Iterator<Integer> empNums = db.keySet().stream()
				.filter(k -> ExtractEmployee.getEmpValue(db.get(k), targetKey).equalsIgnoreCase(targetValue)).sorted()
				.iterator();

		while (empNums.hasNext()) {
			Integer empNum = empNums.next();
			Employee employee = db.get(empNum);
			result.put(empNum, new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(),
					employee.getPhoneNum(), employee.getBirthday(), employee.getCerti()));
			ExtractEmployee.putEmpValue(employee, chageKey, changeValue);
		}
		return result;
	}

	@Override
	public Map<Integer, Employee> search(String key, String value) {
		Map<Integer, Employee> result = new HashMap<>();

		db.keySet().stream().filter(k -> ExtractEmployee.getEmpValue(db.get(k), key).equalsIgnoreCase(value)).sorted()
				.forEach(k -> {
					result.put(k, db.get(k));
				});

		return result;
	}

	private Integer getEmpKey(String employeeNum) {
		char fWord = employeeNum.charAt(0);
		if (fWord > Constants.SEPARATOR_EMPLOYEE_NUM) {
			return Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_BEFORE_MILLENIUM + employeeNum);
		}
		return Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_AFTER_MILLENIUM + employeeNum);
	}

	@Override
	public Map<Integer, Employee> delete(String key, String value, int limit) {
		Map<Integer, Employee> result = new HashMap<>();

		Iterator<Integer> empNums = db.keySet().stream()
				.filter(k -> ExtractEmployee.getEmpValue(db.get(k), key).equalsIgnoreCase(value)).sorted().iterator();

		int limitCnt = 0;
		while (empNums.hasNext()) {
			Integer empNum = empNums.next();
			Employee employee = db.remove(empNum);
			if (limit > limitCnt++)
				result.put(empNum, new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(),
						employee.getPhoneNum(), employee.getBirthday(), employee.getCerti()));
		}

		return result;
	}

	@Override
	public Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue,
			int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Employee> search(String key, String value, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
}
