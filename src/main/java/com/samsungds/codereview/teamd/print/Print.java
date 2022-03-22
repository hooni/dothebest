package com.samsungds.codereview.teamd.print;

import java.io.IOException;
import java.util.Collection;

import com.samsungds.codereview.teamd.vo.Employee;

public interface Print {
	void print(String command, Collection<Employee> employees) throws IOException;
	void print(String command, int count) throws IOException;
	void close() throws IOException;
}
