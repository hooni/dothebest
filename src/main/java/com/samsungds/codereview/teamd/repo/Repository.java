package com.samsungds.codereview.teamd.repo;

import java.util.Map;

import com.samsungds.codereview.teamd.vo.Employee;

public class Repository implements IRepository {

	IRepository repo;
	
	@Deprecated
	public Repository() {
		repo = new MemoryRepository();
	}

	@Override
	public Integer add(Employee emp) {
		return repo.add(emp);
	}

	@Override
	public Map<Integer, Employee> delete(String key, String value) {
		return repo.delete(key, value);
	}

	@Override
	public Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue) {
		return repo.modify(targetKey, targetValue, chageKey, changeValue);
	}

	@Override
	public Map<Integer, Employee> search(String key, String value) {
		return repo.search(key, value);
	}

	@Override
	public Map<Integer, Employee> delete(String key, String value, int limit) {
		return repo.delete(key, value, limit);
	}

	@Override
	public Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue,
			int limit) {
		return repo.modify(targetKey, targetValue, chageKey, changeValue, limit);
	}

	@Override
	public Map<Integer, Employee> search(String key, String value, int limit) {
		return repo.search(key, value, limit);
	}

}
