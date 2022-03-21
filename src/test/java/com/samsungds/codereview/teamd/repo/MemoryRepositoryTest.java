package com.samsungds.codereview.teamd.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.vo.Employee;

class MemoryRepositoryTest {
	private static final String TESTINPUTFILE = "./input_20_20.txt";
	private IRepository repo;
	
	List<Employee> readSample() {
		BufferedReader reader = null;
		List<Employee> empList = new ArrayList<>();
		try {
			String path = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath())
					.getAbsolutePath();
			reader = new BufferedReader(new FileReader(path + TESTINPUTFILE));
			String str;
			while ((str = reader.readLine()) != null) {
				if (str.indexOf("ADD") == 0) {
					String[] empResources = str.split(",");
					Employee emp = new Employee(empResources[4], empResources[5], empResources[6], empResources[7],
							empResources[8], empResources[9]);
					empList.add(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return empList;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}
	
	private void setupData() {
		List<Employee> list = readSample();
		for (Employee emp : list) {
			repo.add(emp);
		}
	}
	
	@BeforeEach
	public void beforeEach() throws IOException {
		repo = new MemoryRepository();
	}
	
	@Test
	void testAddEmpNumCheck() {
		List<Employee> list = readSample();
		for (Employee emp : list) {
			Integer empKey = repo.add(emp);
			if (emp.getEmployeeNum().charAt(0) > Constants.SEPARATOR_EMPLOYEE_NUM) {
				assertEquals(Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_BEFORE_MILLENIUM + emp.getEmployeeNum()),
						empKey);
			} else {
				assertEquals(Integer.valueOf(Constants.EMPLOYEE_NUM_PREFIX_AFTER_MILLENIUM + emp.getEmployeeNum()),
						empKey);
			}
		}
	}

	@Test
	void testAddDuplicateEmp() {
		Employee emp = new Employee("59123456", "Kildong Hong", "CL3", "010-001-0001", "20000101", "PRO");
		Integer empKey = repo.add(emp);
		assertEquals(2059123456, empKey);

		empKey = repo.add(emp);
		assertEquals(0, empKey);
	}

	@Test
	void testDelImpl() {
		setupData();
		
		Map<Integer, Employee> result = repo.delete(Constants.EMPLOYEE_CAREER_LEVEL, "CL3");

		assertEquals(4, result.keySet().size());

	}
	
	@Test
	void testDelLimit() {
		setupData();
		
		Map<Integer, Employee> result = repo.delete(Constants.EMPLOYEE_CERTI, "ADV");

		assertEquals(8, result.keySet().size());
	}

	@Test
	void testModifyImpl() {
		setupData();
		
		Map<Integer, Employee> result = repo.modify(Constants.EMPLOYEE_CAREER_LEVEL, "CL3", Constants.EMPLOYEE_CAREER_LEVEL, "CL4");
		
		assertEquals(4, result.size());
		result.entrySet().stream().forEach(entry -> {
			assertEquals("CL3", entry.getValue().getCl());
		});
	}

	@Test
	void testSearchImpl() {
		setupData();

		Map<Integer, Employee> result = repo.search(Constants.EMPLOYEE_NAME, "TTETHU HBO");
		assertEquals(1, result.size());
		assertEquals("TTETHU HBO", result.get(2018115040).getName());
		assertEquals("20080718", result.get(2018115040).getBirthday());

		result = repo.search(Constants.EMPLOYEE_CAREER_LEVEL, "CL2");
		assertEquals(2, result.size());

		result = repo.search(Constants.EMPLOYEE_BIRTHDAY, "20090201");
		assertEquals(1, result.size());
		assertEquals("RPO JK", result.get(2014130827).getName());
		assertEquals("20090201", result.get(2014130827).getBirthday());
	}

	@Test
	void testSearchOption2() {
		setupData();

		Map<Integer, Employee> result = repo.search(Constants.OPTION2_NAME_FIRST_FIELDNAME, "RTAH");
		assertEquals(1, result.size());
		assertEquals("RTAH VNUP", result.get(2008108827).getName());
		assertEquals("19780417", result.get(2008108827).getBirthday());
		
		result = repo.search(Constants.OPTION2_NAME_LAST_FIELDNAME, "RTIJ");
		assertEquals(1, result.size());
		assertEquals("FBAH RTIJ", result.get(1985125741).getName());
		assertEquals("19780228", result.get(1985125741).getBirthday());
		
		result = repo.search(Constants.OPTION2_PHONENUM_MID_FIELDNAME, "5047");
		assertEquals(0, result.size());
		result = repo.search(Constants.OPTION2_PHONENUM_MID_FIELDNAME, "7986");
		assertEquals("WN XV", result.get(2008123556).getName());
		assertEquals("20100614", result.get(2008123556).getBirthday());
		
		result = repo.search(Constants.OPTION2_PHONENUM_LAST_FIELDNAME, "1699");
		assertEquals(1, result.size());
		assertEquals("SBILHUT LDEXRI", result.get(2002117175).getName());
		assertEquals("19950704", result.get(2002117175).getBirthday());
		
		result = repo.search(Constants.OPTION2_BIRTHDAY_YEAR_FIELDNAME, "2012");
		assertEquals(2, result.size());
		assertEquals("VSID TVO", result.get(2017111236).getName());
		assertEquals("20120718", result.get(2017111236).getBirthday());
		
		result = repo.search(Constants.OPTION2_BIRTHDAY_MONTH_FIELDNAME, "10");
		assertEquals(3, result.size());
		assertEquals("HH LTUPF", result.get(2003113260).getName());
		assertEquals("19791018", result.get(2003113260).getBirthday());
		
		result = repo.search(Constants.OPTION2_BIRTHDAY_DAY_FIELDNAME, "18");
		assertEquals(3, result.size());
		assertEquals("HH LTUPF", result.get(2003113260).getName());
		assertEquals("19791018", result.get(2003113260).getBirthday());
	}
}
