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

	private int phoneNumMid;
	private int phoneNumLast;

	private int birthdayYear;
	private int birthdayMonth;
	private int birthdayDay;

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
		this.phoneNumMid = Integer.parseInt(phoneNumArray[1]);
		this.phoneNumLast = Integer.parseInt(phoneNumArray[2]);
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
		this.birthdayYear = Integer.parseInt(birthday.substring(0, 4));
		this.birthdayMonth = Integer.parseInt(birthday.substring(4, 6));
		this.birthdayDay = Integer.parseInt(birthday.substring(6));
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

	public int getPhoneNumMid() {
		return phoneNumMid;
	}

	public int getPhoneNumLast() {
		return phoneNumLast;
	}

	public int getBirthdayYear() {
		return birthdayYear;
	}

	public int getBirthdayMonth() {
		return birthdayMonth;
	}

	public int getBirthdayDay() {
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
