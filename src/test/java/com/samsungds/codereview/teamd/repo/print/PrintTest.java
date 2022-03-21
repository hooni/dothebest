package com.samsungds.codereview.teamd.repo.print;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.vo.Employee;

public class PrintTest {

	private static String outputFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\outputTest.txt";
	private static File file;
	private static List<Employee> employees = new ArrayList<Employee>();
	
	@BeforeEach
	public void beforeEach() throws IOException {
		employees.add(new Employee("112345", "Kim hong", "cl2", "010-1234-5678", "19881122", "pro"));
		employees.add(new Employee("123344", "lee hong", "cl1", "011-1234-5678", "20020101", "adv"));
		
		file = new File(outputFilePath.toString());
		
		if(file.exists()) {
			new FileWriter(file.getAbsolutePath(), false).close();
		}
		else {
			file.createNewFile();
		}
	}
	
	@AfterEach
	public void afterEach() throws IOException {
		if(file.exists()) {
			new FileWriter(file.getAbsolutePath(), false).close();
		}
		employees.clear();
	}
	
	@Test
	@DisplayName("-p Option이 Enable 된 경우 출력을 테스트합니다.")
	void filePrintOptionDisableTest() {	
		try {
			Print print = new FilePrint(outputFilePath);
			
			print.print(Constants.COMMAND_ADD, employees, true);
			print.close();
			
			int count = 0;
			BufferedReader inFile = new BufferedReader(new FileReader(file)); 
			String sLine = null; 
			while( (sLine = inFile.readLine()) != null ) {
				count++;
			}
			Assertions.assertEquals(count, employees.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("-p Option이 Disable 된 경우 출력을 테스트합니다.")
	void filePrintOptionEnableTest() {
		try {
			Print print = new FilePrint(outputFilePath);
			
			print.print(Constants.COMMAND_ADD, employees, false);
			print.close();
			
			int count = 0;
			BufferedReader inFile = new BufferedReader(new FileReader(file)); 
			String[] sLine = inFile.readLine().split(Constants.SEPARATOR_EMPLOYEE);
			
			
			Assertions.assertEquals(2, Integer.parseInt(sLine[1]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Data가 없는 경우, 출력을 테스트합니다.")
	void filePrintNoDataTest() {
		try {
			Print print = new FilePrint(outputFilePath);
			
			print.print(Constants.COMMAND_ADD, new ArrayList(), false);
			print.close();
			
			int count = 0;
			BufferedReader inFile = new BufferedReader(new FileReader(file)); 
			String[] sLine = inFile.readLine().split(Constants.SEPARATOR_EMPLOYEE);
			
			
			Assertions.assertEquals(Constants.NO_DATA, sLine[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
