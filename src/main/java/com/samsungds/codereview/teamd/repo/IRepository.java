package com.samsungds.codereview.teamd.repo;

import java.util.Map;

import com.samsungds.codereview.teamd.vo.Employee;

public interface IRepository {
	
	//�����Ͱ� ���� ���������� �ԷµǸ� �⵵�� �߰��� ��� ����;
	//�����ϴ� �������̸� 0�� ����;
	Integer add(Employee emp);

	Map<Integer, Employee> delete(String key, String value);
	
	Map<Integer, Employee> modify(String targetKey, String targetValue, String chageKey, String changeValue);
	
	Map<Integer, Employee> search(String key, String value);
	
	Map<Integer, Employee> search(String key, String value, int limit);
	
	int deleteCnt(String key, String value);
	
	int modifyCnt(String targetKey, String targetValue, String chageKey, String changeValue);
	
	int searchCnt(String key, String value);
}
