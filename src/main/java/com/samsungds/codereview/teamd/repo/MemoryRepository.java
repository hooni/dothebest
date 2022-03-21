package com.samsungds.codereview.teamd.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

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
		return delete(key, value, 5);
	}

	@Override
	public Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue) {
		return modify(targetKey, targetValue, chageKey, changeValue, 5);
	}

	@Override
	public Map<Integer, Employee> search(String key, String value) {
		return search(key, value, db.size());
	}

	@Override
	public Map<Integer, Employee> search(String key, String value, int limit) {
		Map<Integer, Employee> result = new TreeMap<>();

		getMatchingKeys(key, value).sorted().limit(limit).forEach(k -> {
			result.put(k, db.get(k));
		});

		return result;
	}

	@Override
	public int deleteCnt(String key, String value) {
		Iterator<Integer> empNums = getMatchingKeys(key, value).iterator();
		
		int size = 0;
		List<Integer> keyList = new ArrayList<Integer>();
		while(empNums.hasNext()) {
			keyList.add(empNums.next());
			size++;
		}
		
		for(Integer k : keyList) {
			db.remove(k);
		}
		
		return (int)size;
	}

	@Override
	public int modifyCnt(String targetKey, String targetValue, String chageKey, String changeValue) {
		Iterator<Integer> empNums = getMatchingKeys(targetKey, targetValue).iterator();

		int size = 0;
		while (empNums.hasNext()) {
			Integer empNum = empNums.next();
			Employee employee = db.get(empNum);
			ExtractEmployee.putEmpValue(employee, chageKey, changeValue);
			size++;
		}

		return size;
	}

	@Override
	public int searchCnt(String key, String value) {
		return (int) getMatchingKeys(key, value).count();
	}

	private Map<Integer, Employee> delete(String key, String value, int printOptionCnt) {
		Map<Integer, Employee> result = new TreeMap<>();
		List<Integer> removeKeys = new ArrayList<>();
		
		Iterator<Integer> empNums = getMatchingKeys(key, value).sorted().iterator();

		//concurrentmodification 문제.
		int limitCnt = 0;
		while (empNums.hasNext()) {
			Integer empNum = empNums.next();
			Employee employee = db.get(empNum);
			removeKeys.add(empNum);
			if (printOptionCnt > limitCnt++)
				result.put(empNum, new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(),
						employee.getPhoneNum(), employee.getBirthday(), employee.getCerti()));
		}
		
		for(Integer k : removeKeys) {
			db.remove(k);
		}

		return result;
	}

	private Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue,
			int printOptionCnt) {
		Map<Integer, Employee> result = new TreeMap<>();

		Iterator<Integer> empNums = getMatchingKeys(targetKey, targetValue).sorted().iterator();

		int limitCnt = 0;
		while (empNums.hasNext()) {
			Integer empNum = empNums.next();
			Employee employee = db.get(empNum);

			if (printOptionCnt > limitCnt++)
				result.put(empNum, new Employee(employee.getEmployeeNum(), employee.getName(), employee.getCl(),
						employee.getPhoneNum(), employee.getBirthday(), employee.getCerti()));

			ExtractEmployee.putEmpValue(employee, chageKey, changeValue);
		}
		return result;
	}

	private Stream<Integer> getMatchingKeys(String key, String value) {
		return db.keySet().stream().filter(k -> ExtractEmployee.getEmpValue(db.get(k), key).equalsIgnoreCase(value));
	}

	private Integer getEmpKey(String employeeNum) {
		char fWord = employeeNum.charAt(0);
		if (fWord > Constants.SEPARATOR_EMPLOYEE_NUM) {
			return Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_BEFORE_MILLENIUM + employeeNum);
		}
		return Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_AFTER_MILLENIUM + employeeNum);
	}
}
