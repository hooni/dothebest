package com.samsungds.codereview.teamd.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.samsungds.codereview.teamd.vo.Employee;

@ExtendWith(MockitoExtension.class)
class RepositoryTest {
	@Mock
	IRepository repoMock;

	@Test
	void testAdd() {
		Employee emp = new Employee("00123456", "�浿 ȫ", "CL3", "010-001-0001", "20000101", "PRO");

		when(repoMock.add(emp)).thenReturn(Integer.valueOf("20" + emp.getEmployeeNum()));

		assertEquals(Integer.valueOf("20" + emp.getEmployeeNum()), repoMock.add(emp));
	}

	@Test
	void testDelete() {
		Map<Integer, Employee> map = new HashMap<>();

		when(repoMock.delete(anyString(), anyString())).thenReturn(map);

		assertEquals(map, repoMock.delete("name", "test"));
	}

	@Test
	void testModify() {
		Map<Integer, Employee> map = new HashMap<>();

		when(repoMock.modify(anyString(), anyString(), anyString(), anyString())).thenReturn(map);

		assertEquals(map, repoMock.modify("name", "test", "name", "ok"));
	}

	@Test
	void testSearch() {
		Map<Integer, Employee> map = new HashMap<>();

		when(repoMock.search(anyString(), anyString())).thenReturn(map);

		assertEquals(map, repoMock.search("name", "test"));
	}
}
