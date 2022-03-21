package com.samsungds.codereview.teamd.print;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.vo.Employee;

public class FilePrint implements Print {
	private BufferedWriter writer;
	
	public FilePrint(String path) throws IOException {
		File file = new File(path);
		
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		writer = new BufferedWriter(new FileWriter(file));
	}
	
	public void print(String command, Collection<Employee> employees, Boolean printOptionEnable) throws IOException {
		if(employees.size() == 0) {
			write(command + Constants.SEPARATOR_EMPLOYEE + Constants.NO_DATA);
		}
		else {
			if(printOptionEnable) {
				for(Employee employee : employees) {
					write(command + Constants.SEPARATOR_EMPLOYEE + employee.toInfoString());
				}
			}
			else {
				write(command + Constants.SEPARATOR_EMPLOYEE + employees.size());
			}
		}
	}
	
	public void close() throws IOException {
		writer.close();
	}
	
	private void write(String str) throws IOException {
		writer.write(str);	
		writer.newLine();
	}
}
