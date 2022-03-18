package com.samsungds.codereview.teamd.repo;

import java.util.Map;

import com.samsungds.codereview.teamd.vo.Employee;

public interface IRepository {
	
	//�����Ͱ� ���� ���������� �ԷµǸ� �⵵�� �߰��� ��� ����;
	//�����ϴ� �������̸� 0�� ����;
	Integer add(Employee emp);

	Map<Integer, Employee> delete(String key, String value);

	Map<Integer, Employee> modify(String anyString, String anyString2);
	
	Map<Integer, Employee> search(String key, String value);
}
