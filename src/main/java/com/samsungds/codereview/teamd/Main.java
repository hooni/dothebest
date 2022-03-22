package com.samsungds.codereview.teamd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.samsungds.codereview.teamd.command.CommandFactory;
import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.MemoryRepository;

public class Main {

	public static void main(String[] args) throws IOException {
		argumentValid(args);
		run(args[0], args[1]);
	}

	private static void run(String inputFile, String outputFile) throws IOException {
		Print print = null;
		BufferedReader br = null;
		try{
			print = new FilePrint(outputFile);
			br = new BufferedReader(new FileReader(inputFile));
			executeCommad(print, br);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally{
			if(br != null) br.close();
			if(print != null) print.close();
		}
	}

	private static void executeCommad(Print print, BufferedReader br) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			if (stringNullOrEmpty(line))
				continue;
			try {
				CommandFactory.getCommand(line.split(Constants.SEPARATOR_EMPLOYEE)[0], new MemoryRepository(), print)
						.execute(line);
			} catch (IllegalArgumentException ignore) {
				ignore.printStackTrace();
			}
		}
	}

	private static void argumentValid(String[] args) {
		if (args == null || args.length != 2 || stringNullOrEmpty(args[0]) || stringNullOrEmpty(args[0])) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean stringNullOrEmpty(String s) {
		if (s == null || s.trim().length() == 0)
			return true;
		return false;
	}
}
