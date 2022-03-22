package com.samsungds.codereview.teamd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.samsungds.codereview.teamd.command.CommandFactory;
import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.Repository;

public class Main {

	public static void main(String[] args) throws IOException {
		if (args == null || args.length != 2 || args[0] == null || args[0].trim().length() == 0 || args[1] == null
				|| args[1].trim().length() == 0) {
			throw new IllegalArgumentException();
		}

		String inputFile = args[0];
		String outputFile = args[1];

		IRepository repository = new Repository();
		Print print = new FilePrint(outputFile);

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line == null || line.trim().length() == 0) continue;
				try {
					CommandFactory.getCommand(line.split(Constants.SEPARATOR_EMPLOYEE)[0], repository, print).execute(line);
				} catch (IllegalArgumentException ignore) {
					ignore.printStackTrace();
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		print.close();
	}
}
