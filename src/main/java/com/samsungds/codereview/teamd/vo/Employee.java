package com.samsungds.codereview.teamd.vo;

import com.samsungds.codereview.teamd.constant.Constants;

public class Employee {
	
	private String employeeNum;
	private String name;
	private String cl;
	private String phoneNum;
	private String birthday;
	private String certi;

	private int employeeNumForSort;

	private String nameFirst;
	private String nameLast;

	private String phoneNumMid;
	private String phoneNumLast;

	private String birthdayYear;
	private String birthdayMonth;
	private String birthdayDay;

	public Employee(String employeeNum, String name, String cl, String phoneNum, String birthday, String certi) {
		this.employeeNum = employeeNum;
		this.cl = cl;
		this.certi = certi;
		setName(name);
		setPhoneNum(phoneNum);
		setBirthday(birthday);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		String[] nameArray = name.split(Constants.SEPARATOR_NAME);
		this.nameFirst = nameArray[0];
		this.nameLast = nameArray[1];
	}

	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		String[] phoneNumArray = phoneNum.split(Constants.SEPARATOR_PHONENUM);
		this.phoneNumMid = phoneNumArray[1];
		this.phoneNumLast =phoneNumArray[2];
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
		this.birthdayYear = birthday.substring(0, 4);
		this.birthdayMonth = birthday.substring(4, 6);
		this.birthdayDay = birthday.substring(6);
	}

	public String getCerti() {
		return certi;
	}

	public void setCerti(String certi) {
		this.certi = certi;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNumForSort(int employeeNumForSort) {
		this.employeeNumForSort = employeeNumForSort;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public String getPhoneNumMid() {
		return phoneNumMid;
	}

	public String getPhoneNumLast() {
		return phoneNumLast;
	}

	public String getBirthdayYear() {
		return birthdayYear;
	}

	public String getBirthdayMonth() {
		return birthdayMonth;
	}

	public String getBirthdayDay() {
		return birthdayDay;
	}

	public int getEmployeeNumForSort() {
		return employeeNumForSort;
	}

	@Override
	public String toString() {
		return "Employee [employeeNum=" + employeeNum + ", name=" + name + ", cl=" + cl + ", phoneNum=" + phoneNum
				+ ", birthday=" + birthday + ", certi=" + certi + ", employeeNumForSort=" + employeeNumForSort
				+ ", nameFirst=" + nameFirst + ", nameLast=" + nameLast + ", phoneNumMid=" + phoneNumMid
				+ ", phoneNumLast=" + phoneNumLast + ", birthdayYear=" + birthdayYear + ", birthdayMonth="
				+ birthdayMonth + ", birthdayDay=" + birthdayDay + "]";
	}

	public String toInfoString() {
		return employeeNum + Constants.SEPARATOR_EMPLOYEE + name + Constants.SEPARATOR_EMPLOYEE + cl
				+ Constants.SEPARATOR_EMPLOYEE + phoneNum + Constants.SEPARATOR_EMPLOYEE + birthday
				+ Constants.SEPARATOR_EMPLOYEE + certi;
	}
}
