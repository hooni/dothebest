package com.samsungds.codereview.teamd.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

	private Employee employee;

	@BeforeEach
	void setUp() {
		employee = new Employee("18050301", "KYUMOK KIM", "CL2", "010-9777-6055", "19980906", "PRO");
	}

	@Test
	void construnctorTest() {
		assertEquals("18050301", employee.getEmployeeNum());
		assertEquals("KYUMOK KIM", employee.getName());
		assertEquals("CL2", employee.getCl());
		assertEquals("010-9777-6055", employee.getPhoneNum());
		assertEquals("19980906", employee.getBirthday());
		assertEquals("PRO", employee.getCerti());

		assertEquals("KYUMOK", employee.getNameFirst());
		assertEquals("KIM", employee.getNameLast());

		assertEquals(9777, employee.getPhoneNumMid());
		assertEquals(6055, employee.getPhoneNumLast());

		assertEquals(1998, employee.getBirthdayYear());
		assertEquals(9, employee.getBirthdayMonth());
		assertEquals(6, employee.getBirthdayDay());
		
		assertEquals(0, employee.getEmployeeNumForSort());
	}

	@Test
	void modifyNameTest() {
		employee.setName("WONGEUN LEE");
		assertEquals("WONGEUN LEE", employee.getName());
		assertEquals("WONGEUN", employee.getNameFirst());
		assertEquals("LEE", employee.getNameLast());
	}

	@Test
	void modifyClTest() {
		employee.setCl("CL3");
		assertEquals("CL3", employee.getCl());
	}

	@Test
	void modifyPhoneNumberTest() {
		employee.setPhoneNum("010-9776-6054");
		assertEquals("010-9776-6054", employee.getPhoneNum());
		assertEquals(9776, employee.getPhoneNumMid());
		assertEquals(6054, employee.getPhoneNumLast());
	}

	@Test
	void modifyBirthdayTest() {
		employee.setBirthday("19991007");
		assertEquals("19991007", employee.getBirthday());
		assertEquals(1999, employee.getBirthdayYear());
		assertEquals(10, employee.getBirthdayMonth());
		assertEquals(7, employee.getBirthdayDay());
	}

	@Test
	void modifyCertiTest() {
		employee.setCerti("EX");
		assertEquals("EX", employee.getCerti());
	}
	
	@Test
	void modifyEmployeeNumForSortTest() {
		employee.setEmployeeNumForSort(2018050301);
		assertEquals(2018050301, employee.getEmployeeNumForSort());
	}

	@Test
	void infoStringTest() {
		assertEquals("18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO", employee.toInfoString());
	}

	@Test
	void toStringTest() {
		assertEquals(
				"Employee [employeeNum=18050301, name=KYUMOK KIM, cl=CL2, phoneNum=010-9777-6055, birthday=19980906, certi=PRO, "
						+"employeeNumForSort=0, nameFirst=KYUMOK, nameLast=KIM, phoneNumMid=9777, phoneNumLast=6055, "
						+"birthdayYear=1998, birthdayMonth=9, birthdayDay=6]",
				employee.toString());
	}

}
