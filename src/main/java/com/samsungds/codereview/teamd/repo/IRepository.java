package com.samsungds.codereview.teamd.repo;

import java.util.Map;

import com.samsungds.codereview.teamd.vo.Employee;

public interface IRepository {
	
	//데이터가 없고 정상적으로 입력되면 년도가 추가된 사번 리턴;
	//존재하는 데이터이면 0을 리턴;
	Integer add(Employee emp);

	Map<Integer, Employee> delete(String key, String value);

	Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue);
	
	Map<Integer, Employee> search(String key, String value);
}
