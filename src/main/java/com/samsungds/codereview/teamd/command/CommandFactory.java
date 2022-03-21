package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;

public class CommandFactory {

	public static ICommand getCommand(String commandString, IRepository repository, Print print) {
		if (repository == null) throw new IllegalArgumentException();
		if (print == null) throw new IllegalArgumentException();
		ICommand command = null;
		switch (commandString) {
			case Constants.COMMAND_ADD:
				command = new AddCommand();
				break;
			case Constants.COMMAND_MODIFY:
				command = new ModCommand();
				break;
			case Constants.COMMAND_SEARCH:
				command = new SchCommand();
				break;
			case Constants.COMMAND_DEL:
				command = new DelCommand();
				break;
			default:
				throw new IllegalArgumentException("Illegal command [" + commandString + "]");
		}
		command.setFilePrint(print);
		command.setRepository(repository);
		return command;
	}
}
